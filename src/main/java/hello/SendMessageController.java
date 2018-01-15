package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendMessageController {
    
    private Sender sender;

    public SendMessageController(Sender sender) {
        this.sender = sender;
    }
    
    @RequestMapping( value = "/test")
    public ResponseEntity<String> sendMessage() {
        
        sender.send("hi " + System.currentTimeMillis());
        
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
