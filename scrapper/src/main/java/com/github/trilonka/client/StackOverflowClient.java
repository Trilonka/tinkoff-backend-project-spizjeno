package com.github.trilonka.client;

import com.github.trilonka.config.StackOverflowConfig;
import com.github.trilonka.dto.response.StackOverflowQuestionResponse;
import com.github.trilonka.dto.response.StackOverflowQuestionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class StackOverflowClient implements Client {

    private static final String GET_QUESTIONS_ENDPOINT = "/questionsss/%s?site=stackoverflow";

    private final WebClient webClient;

    public static StackOverflowClient fromConfig(StackOverflowConfig config) {
        WebClient webClient = WebClient.builder()
                .baseUrl(config.baseUrl())
                .build();

        return new StackOverflowClient(webClient);
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

    public Optional<StackOverflowQuestionResponse> fetchQuestion(long questionId) {
        String uri = String.format(GET_QUESTIONS_ENDPOINT, questionId);

        return get(uri, StackOverflowQuestionsResponse.class)
                .filter(questions -> !questions.items().isEmpty())
                .map(questions -> questions.items().get(0));
    }
}
