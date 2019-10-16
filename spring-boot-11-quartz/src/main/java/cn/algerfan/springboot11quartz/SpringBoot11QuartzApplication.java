package cn.algerfan.springboot11quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot11QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot11QuartzApplication.class, args);
    }

}

