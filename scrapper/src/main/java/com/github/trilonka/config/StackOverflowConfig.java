package com.github.trilonka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "stackoverflow-client")
public record StackOverflowConfig(
        @DefaultValue("https://api/stackexchange.com/2.3") String baseUrl
) {
}
