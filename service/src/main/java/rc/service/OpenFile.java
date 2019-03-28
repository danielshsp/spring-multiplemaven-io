package rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.domain.Event;

import java.util.concurrent.CompletableFuture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Component
public class OpenFile implements CommandLineRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(String...args) throws Exception {

        CompletableFuture<String> page1= eventService.getFormExe();
        // Wait until they are all done
        CompletableFuture.allOf(page1).join();
        System.out.println("get data from async method" +page1.get());



    }

}
