package com.github.trilonka.response;

public sealed interface BaseResponse permits GitHubResponse, StackOverflowResponse {
}
