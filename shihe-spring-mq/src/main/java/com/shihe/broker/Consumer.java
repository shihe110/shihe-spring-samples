package com.shihe.broker;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    private static final String defaultURL = "tcp://localhost:61616";
    private static final String defaultDestName = "shihe";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(defaultURL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(defaultDestName);
        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage receive = (TextMessage) consumer.receive();
        String text = receive.getText();
        System.out.println(text);

        consumer.close();
        session.close();
        connection.close();
    }
}
