package com.github.trilonka.dto.response;

import java.util.List;

public record StackOverflowQuestionsResponse(
        List<StackOverflowQuestionResponse> items
) {
}
