package rc.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.concurrent.CompletableFuture;

@Service
public class Pruducer {

    private static Logger log = LoggerFactory.getLogger(Pruducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    Queue queue;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> sendTopic(String message) throws InterruptedException {
        log.info("sending a message by convertAndSend() to topic:" + message );
        jmsTemplate.convertAndSend(queue, message);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(2000L);
        return CompletableFuture.completedFuture(message);
    }
    /*public void sendTopic(String message) {
        log.info("sending a message by convertAndSend() to topic:" + message );
        jmsTemplate.convertAndSend(queue, message);
    }*/
}
