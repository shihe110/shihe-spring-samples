package com.shihe.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultQ = "shihe";
    public static void main(String[] args) throws JMSException {
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
        // 接受消息  阻塞接受消息
        TextMessage receive = (TextMessage) consumer.receive();
        /*// 定时接受消息 并退出
        TextMessage receive = (TextMessage) consumer.receive(3000L);*/
        // 获取消息
        String text = receive.getText();
        System.out.println(text);
        // 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
