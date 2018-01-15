
package com.rhc.jms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Application {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        final ConfigurableEnvironment environment = context.getEnvironment();
        LOGGER.info(String.format("Queue Name %s", environment.getProperty("jms.queueName")));
    }
}
