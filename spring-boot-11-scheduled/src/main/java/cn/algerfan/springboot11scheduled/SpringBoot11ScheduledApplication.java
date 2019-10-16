package cn.algerfan.springboot11scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot11ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot11ScheduledApplication.class, args);
    }

}

