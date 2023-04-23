package com.github.trilonka.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TelegramChatController {

    @PostMapping(path = "/th-chat/{id}")
    public String registerChat(@PathVariable(name = "id") long id) {
        return "Register chat";
    }

    @DeleteMapping(path = "/th-chat/{id}")
    public String deleteChat(@PathVariable(name = "id") long id) {
        return "Chat deleted";
    }
}

