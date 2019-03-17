package rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.domain.Event;
import rc.persistence.DaoEvent;
import rc.service.jms.Pruducer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Service
public class EventService {

    @Autowired
    ObjectMapper ObjectMappe;
    @Autowired
    DaoEvent daoEvent;
    @Autowired
    Pruducer pruducer;


    public List<Event> findAll(){

        pruducer.sendTopic("Get  all of event list");
        return daoEvent.findAll();
    }

    public Event findByeventId(int eventId){
        return daoEvent.findByeventId(eventId);
    }

    public Event save(Event event){
        return daoEvent.save(event);
    }

    public void create(String message) throws IOException {
        if(!message.contains("Get  all of event list")){
            String json = message;
            Event event = ObjectMappe.readValue(json,Event.class);
            daoEvent.save(event);
        }

    }

    public void sentFormExe(String message){

        pruducer.sendTopic(message);

    }

}
