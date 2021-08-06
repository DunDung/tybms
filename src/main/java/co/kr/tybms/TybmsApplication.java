package co.kr.tybms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TybmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TybmsApplication.class, args);
    }
}