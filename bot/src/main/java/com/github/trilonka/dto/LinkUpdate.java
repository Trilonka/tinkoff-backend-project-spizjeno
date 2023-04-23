package com.github.trilonka.dto;

import java.net.URI;
import java.util.List;

public record LinkUpdate(
        long id,
        URI url,
        String description,
        List<Long> thChatIds
) {
}
