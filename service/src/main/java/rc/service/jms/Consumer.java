package rc.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import rc.service.EventService;

import java.io.IOException;

@Component
public class Consumer {
    @Autowired
    EventService eventService;
    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "event-topic")
    public void consume(String message) {

        log.info("received:" + message );
        try {
                if(!message.contains("Get  all of event list")  ) {
                    eventService.create(message);
                }
        } catch (IOException e) {
                e.printStackTrace();
        }

    }

}
