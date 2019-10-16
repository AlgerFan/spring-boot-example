package cn.algerfan.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口
 * @author algerfan
 */
@MapperScan(value = "cn.algerfan.springboot.mapper")
@SpringBootApplication
public class SpringBoot06MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06MybatisApplication.class, args);
    }

}

