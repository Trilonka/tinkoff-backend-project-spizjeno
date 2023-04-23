package com.github.trilonka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "github-client")
public record GitHubConfig(
        @DefaultValue("https://api.github.com") String baseUrl,
        @DefaultValue("2022-11-28") String apiVersion
) {
}
