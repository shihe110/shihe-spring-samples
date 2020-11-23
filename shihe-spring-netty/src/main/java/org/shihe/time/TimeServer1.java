package org.shihe.time;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeServer1
 * @Description TODO
 * @Author admin
 * @Date 2020-11-23 17:19
 * @Version 1.0
 */
public class TimeServer1 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args!=null&&args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : "+port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 100);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }

        }finally {
            if (server!=null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }

    }
}
