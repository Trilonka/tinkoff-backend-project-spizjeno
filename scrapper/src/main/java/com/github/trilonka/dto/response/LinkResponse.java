package com.github.trilonka.dto.response;

import java.net.URI;

public record LinkResponse(
        long id,
        URI link
) {
}
