package com.github.trilonka.controller;

import com.github.trilonka.dto.request.AddLinkRequest;
import com.github.trilonka.dto.request.RemoveLinkRequest;
import com.github.trilonka.dto.response.LinkResponse;
import com.github.trilonka.dto.response.ListLinkResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private static final String TG_CHAT_HEADER = "Tg-Chat-Id";

    @GetMapping
    public ListLinkResponse getLinks(@RequestHeader(name = TG_CHAT_HEADER) long thChatId) {
        return new ListLinkResponse(List.of(), 0);
    }

    @PostMapping
    public LinkResponse addLink(
            @RequestHeader(name = TG_CHAT_HEADER) long thChatId,
            @RequestBody AddLinkRequest addLinkRequest
    ) {
        // TODO: handle "chat not found" exception

        return new LinkResponse(UUID.randomUUID().hashCode(), addLinkRequest.link());
    }

    @DeleteMapping
    public LinkResponse removeLink(
            @RequestHeader(name = TG_CHAT_HEADER) long tgChatId,
            @RequestBody RemoveLinkRequest removeLinkRequest
    ) {

        // TODO: handle "chat not found" and "link not found" exceptions

        return new LinkResponse(UUID.randomUUID().hashCode(), removeLinkRequest.link());
    }
}
