package com.shihe.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class TopicConsumer {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultQ = "shihe_topic";
    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("第一个消费者");
        // 工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(defaultURL);
        // 连接 启动
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 目的地
        Topic topic = session.createTopic(defaultQ);
        // 消费者
        MessageConsumer consumer = session.createConsumer(topic);
        // 消费
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {
                    try {
                        String text = ((TextMessage) message).getText();
                        System.out.println(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 释放
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
