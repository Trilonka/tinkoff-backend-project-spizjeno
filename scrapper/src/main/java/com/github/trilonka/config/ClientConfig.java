package com.github.trilonka.config;

import com.github.trilonka.client.GitHubClient;
import com.github.trilonka.client.StackOverflowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClientConfig {

    private final GitHubConfig gitHubConfig;
    private final StackOverflowConfig stackOverflowConfig;

    @Bean
    public GitHubClient gitHubClient() {
        return GitHubClient.fromConfig(gitHubConfig);
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return StackOverflowClient.fromConfig(stackOverflowConfig);
    }

    @Bean
    public long linkUpdateSchedulerIntervalMs(ApplicationConfig config) {
        return config.scheduler().interval().toMillis();
    }
}
