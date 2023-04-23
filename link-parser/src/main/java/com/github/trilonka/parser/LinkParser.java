package com.github.trilonka.parser;

import com.github.trilonka.response.BaseResponse;

import java.util.Optional;

public interface LinkParser {

    Optional<BaseResponse> parse(String link);
}
