package rc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.service.EventService;
import rc.domain.Event;

import java.util.List;

@RestController
@RequestMapping(value= "/rest")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "/event/all")
    public List<Event> getAllEvent(){
        return eventService.findAll();
    }

    @GetMapping(value = "/company/{id}")
    public Event getEventById(@PathVariable final int id){
        return eventService.findByeventId(id);
    }






}
