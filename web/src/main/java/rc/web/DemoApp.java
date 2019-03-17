package rc.web;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"rc"})
@EntityScan(basePackages = {"rc"})
@ComponentScan(basePackages = {"rc"})

public class DemoApp {


    public static void main(String[] args){

        SpringApplication.run(DemoApp.class, args);
      //ConfigurableApplicationContext context = SpringApplication.run(DemoApp.class, args);
        //JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

    }
}
