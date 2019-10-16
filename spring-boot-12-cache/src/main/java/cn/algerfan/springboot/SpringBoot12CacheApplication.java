package cn.algerfan.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@MapperScan("cn.algerfan.springboot.mapper")
@SpringBootApplication
//开启基于注解的缓存
@EnableCaching
public class SpringBoot12CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot12CacheApplication.class, args);
    }

}

