package com.shihe.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.omg.CORBA.UserException;

import javax.jms.*;

public class Producer {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultQ = "shihe_topic";

    public static void main(String[] args) throws Exception {
        // 建工程
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(defaultURL);
        // 创建连接 启动方位
        Connection connection = factory.createConnection();
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建目的地
        Topic topic = session.createTopic(defaultQ);
        // 创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        // 发送消息
        for (int i = 1; i <= 4; i++) {
            TextMessage msg = session.createTextMessage("我的第" + i + "个topic消息");
            System.out.println(i);
            producer.send(msg);
        }
        // 释放资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("----------------");
    }
}
