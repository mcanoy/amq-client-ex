package com.rhc.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageSenderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderController.class);
   
    @RequestMapping("/amq")
    public ModelAndView amqMessage() {

        String error = "";
        
        try {
            InitialContext initCtx = new InitialContext();
            Context envContext = (Context) initCtx.lookup("java:comp/env");
            ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup("jms/ConnectionFactory");
            Destination destination = (Destination) envContext.lookup("jms/queue/test-queue");
         
            JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);           
            jmsTemplate.convertAndSend(destination, "tomcat!!!!");
            
            error = destination.toString();
            
            LOGGER.info("Message sent" + error);

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.getProperties().list(pw);
            error = sw.toString();
        }
 
        String message = "<h3>" + error + "</h3><br><div style='text-align:center;'><h3>AMQ</h3></div>";
        return new ModelAndView("amq", "message", message);
    }
}
