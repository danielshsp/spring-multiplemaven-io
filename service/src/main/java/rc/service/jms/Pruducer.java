package rc.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class Pruducer {

    private static Logger log = LoggerFactory.getLogger(Pruducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    Queue queue;

    public void sendTopic(String message) {
        log.info("sending a message by convertAndSend() to topic:" + message );
        jmsTemplate.convertAndSend(queue, message);
    }
}
