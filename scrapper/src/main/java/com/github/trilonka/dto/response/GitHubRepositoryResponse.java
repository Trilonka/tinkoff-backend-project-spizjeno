package com.github.trilonka.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record GitHubRepositoryResponse(
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("full_name") String fullName
) {
}
