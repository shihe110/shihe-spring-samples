package org.shihe.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.security.cert.CertificateException;

/**
 * @ClassName EchoServer
 * @Description TODO
 * @Author admin
 * @Date 2020-11-23 12:08
 * @Version 1.0
 */
public class EchoServer {

    static final boolean SSL = System.getProperty("ssl")!=null;
    static final int PORT = Integer.parseInt(System.getProperty("port","8007"));
    public static void main(String[] args) throws Exception {
        final SslContext sslCtx;
        if (SSL){
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
        }else {
            sslCtx = null;
        }
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            if (sslCtx!=null){
                                p.addLast(sslCtx.newHandler(socketChannel.alloc()));
                            }
                            p.addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind(PORT).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
