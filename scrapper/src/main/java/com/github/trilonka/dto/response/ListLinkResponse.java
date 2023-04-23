package com.github.trilonka.dto.response;

import java.util.List;

public record ListLinkResponse(
        List<LinkResponse> links,
        int size
) {
}
