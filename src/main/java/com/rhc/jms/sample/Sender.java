package com.rhc.jms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Sends 100K JMS messages.
 */
@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Value("${jms.queueName}")
    private String destination;

    public void send(String message) {
      LOGGER.info("sending message='{}' to destination='{}'", message, destination);
      jmsTemplate.convertAndSend(destination, message);
    }
}
