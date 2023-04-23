package com.github.trilonka.client;

import com.github.trilonka.config.GitHubConfig;
import com.github.trilonka.dto.response.GitHubRepositoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class GitHubClient implements Client {

    private static final String GET_REPO_ENDPOINT = "/repos/%s/%s";

    private final WebClient webClient;

    public static GitHubClient fromConfig(GitHubConfig config) {
        WebClient webClient = WebClient.builder()
                .baseUrl(config.baseUrl())
                .defaultHeader("X-GitHub-Api-Version", config.apiVersion())
                .build();

        return new GitHubClient(webClient);
    }

    @Override
    public <T> Optional<T> get(String uri, Class<T> destClass) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(destClass)
                .onErrorResume(WebClientResponseException.class, exception -> Mono.empty())
                .blockOptional();
    }

    public Optional<GitHubRepositoryResponse> fetchRepository(String owner, String repo) {
        String uri = String.format(GET_REPO_ENDPOINT, owner, repo);

        return get(uri, GitHubRepositoryResponse.class);

    }
}
