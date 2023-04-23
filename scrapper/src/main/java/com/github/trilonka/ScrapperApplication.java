package com.github.trilonka;

import com.github.trilonka.config.ApplicationConfig;
import com.github.trilonka.config.GitHubConfig;
import com.github.trilonka.config.StackOverflowConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
        ApplicationConfig.class,
        GitHubConfig.class,
        StackOverflowConfig.class
})
public class ScrapperApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ScrapperApplication.class, args);
        ApplicationConfig config = context.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}
