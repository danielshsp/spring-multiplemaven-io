package rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import rc.domain.Event;
import rc.persistence.DaoEvent;
import rc.service.jms.Pruducer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class EventService {

    @Autowired
    ObjectMapper ObjectMappe;
    @Autowired
    DaoEvent daoEvent;
    @Autowired
    Pruducer pruducer;


    public List<Event> findAll() {

       // pruducer.sendTopic("Get  all of event list");
        return daoEvent.findAll();
    }

    public long countOfdata(String data) {
        return daoEvent.countOfdata(data);
    }

    public long countOfEventType(String eventType) {
        return daoEvent.countOfEventType(eventType);
    }

    public Event findByeventId(int eventId) {
        return daoEvent.findByeventId(eventId);
    }


    public Event save(Event event) {
        return daoEvent.save(event);
    }

    public void create(String message) throws IOException {
        if (!message.contains("Get  all of event list")) {
            String json = message;
            Event event = ObjectMappe.readValue(json, Event.class);
            daoEvent.save(event);
        }

    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> getFormExe() throws InterruptedException {

        CompletableFuture<String> page1 = null;
        String line;
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", "c:/windows/generator.exe");
        try {

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((line = reader.readLine()) != null) {
                if (line.length() > 15) {
                    // Artificial delay of 1s for demonstration purposes
                    try {
                             Thread.sleep(2000L);
                             sentFormExe(line);
                    } catch (ExecutionException e) {

                        e.printStackTrace();
                    }

                }
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void sentFormExe(String message) throws InterruptedException, ExecutionException {

        CompletableFuture<String> page2 = pruducer.sendTopic(message);
        // Wait until they are all done
        CompletableFuture.allOf(page2).join();
        System.out.println("get data from async method" +page2.get());

    }
}
