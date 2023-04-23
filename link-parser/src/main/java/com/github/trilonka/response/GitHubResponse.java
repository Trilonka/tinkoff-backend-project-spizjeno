package com.github.trilonka.response;

public record GitHubResponse(String user, String repo) implements BaseResponse {
}
