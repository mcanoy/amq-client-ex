package com.rhc.jms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Receives JMS messages from the configured queue using the configured selector.
 */
@Component
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "${jms.queueName}")
    public void receive(String message) {
      LOGGER.info("received message='{}'", message);
    }
  }
