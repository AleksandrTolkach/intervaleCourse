package by.tolkach.smev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SmevApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmevApplication.class, args);
    }
}
