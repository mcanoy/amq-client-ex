
package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableJms
public class Application {
    @Value("${jms.queueName:mailbox-destination}")
    String queueName;
    @Value("${sleepTime:0}")
    long sleepTimeInMs;


    public static void main(String[] args) {
        // Clean out any ActiveMQ data from a previous run
        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        final ConfigurableEnvironment environment = context.getEnvironment();
        final String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("Profiles");
        System.out.println(environment.getProperty("jms.queueName"));
        for (String profile : activeProfiles) {
            System.out.println("  - " + profile);
        }

        //System.out.println("press CTRL-C to exit, using queue " + environment.getProperty("jms.queueName"));
     //   try {
     //       System.in.read();
     //   } catch (IOException e) {
     //       e.printStackTrace();
     //   }
    }
    
    

}
