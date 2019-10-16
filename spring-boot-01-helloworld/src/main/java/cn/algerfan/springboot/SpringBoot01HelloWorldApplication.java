package cn.algerfan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class SpringBoot01HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01HelloWorldApplication.class, args);
    }

}

