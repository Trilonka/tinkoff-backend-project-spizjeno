package com.github.trilonka.controller;

import com.github.trilonka.dto.LinkUpdate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/updates")
public class UpdateController {

    @PostMapping
    public String createUpdate(@RequestBody LinkUpdate update) {
        return "Update completed";
    }
}
