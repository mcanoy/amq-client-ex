package com.rhc.jms.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendMessageController {
    
    private Sender sender;

    public SendMessageController(Sender sender) {
        this.sender = sender;
    }
    
    @RequestMapping( value = "/test")
    public ResponseEntity<String> sendMessage(@RequestParam(name="message") String message) {
        
        if(message == null) {
            message = "hi";
        }
        
        String queueMessage = String.format("%s (%d%n)", message, System.currentTimeMillis()); 
        
        sender.send(queueMessage);
        
        return new ResponseEntity<>(queueMessage, HttpStatus.OK);
    }
}
