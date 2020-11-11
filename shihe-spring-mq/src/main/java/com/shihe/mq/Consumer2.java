package com.shihe.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Consumer2 {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultQ = "shihe";
    public static void main(String[] args) throws JMSException, IOException {
        //1、创建工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(defaultURL);
        // 创建连接并启动
        Connection connection = factory.createConnection();
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建目的地
        Queue queue = session.createQueue(defaultQ);
        // 创建消息消费者并将目的地赋给
        MessageConsumer consumer = session.createConsumer(queue);
        // 设置监听接受消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage m = (TextMessage) message;
                String text = null;
                try {
                    text = m.getText();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.out.println(text);
            }
        });
        //
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
