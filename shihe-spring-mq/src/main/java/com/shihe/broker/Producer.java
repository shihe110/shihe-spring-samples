package com.shihe.broker;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultQ = "shihe";
    public static void main(String[] args) throws JMSException {
        // 1创建工厂
        ActiveMQConnectionFactory fac = new ActiveMQConnectionFactory(defaultURL);

        // 2创建连接 并连接启动
        Connection connection = fac.createConnection();
        connection.start();
        // 3创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4创建消息目标
        Queue queue = session.createQueue(defaultQ);
        // 5创建消息创建者，并设定消息目的地
        MessageProducer producer = session.createProducer(queue);

        //6创建消息
        for (int i = 1; i < 3; i++) {
            TextMessage message = session.createTextMessage("第"+i+"个消息");
            // 7发送消息
            producer.send(message);
        }

        // 释放资源
        producer.close();
        session.close();
        connection.close();

    }
}
