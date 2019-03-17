package rc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rc.domain.Event;

import java.util.List;

@Repository
public class DaoEvent {

    @Autowired
    EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event findByeventId(int eventId){
        return eventRepository.findByeventId(eventId).get();
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }


}
