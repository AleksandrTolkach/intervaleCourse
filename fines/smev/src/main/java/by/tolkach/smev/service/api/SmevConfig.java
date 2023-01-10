package by.tolkach.smev.service.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class SmevConfig {

    @Bean
    public ExecutorService getExecutorService() {
        return Executors.newSingleThreadExecutor();
    }
}
