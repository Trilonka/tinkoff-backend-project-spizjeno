package com.github.trilonka.parser;

import com.github.trilonka.response.BaseResponse;
import com.github.trilonka.response.StackOverflowResponse;

import java.util.Optional;
import java.util.regex.Pattern;

public class StackOverflowParser extends LinkChainParser {

    private static final Pattern QID_PATTERN = Pattern.compile("^https://stackoverflow\\.com/questions/(\\d+)(/|$)");

    @Override
    public Optional<BaseResponse> parse(String link) {
        var matcher = QID_PATTERN.matcher(link);
        if (matcher.find()) {
            String questionId = matcher.group(1);
            return Optional.of(new StackOverflowResponse(questionId));
        }
        return parseNext(link);
    }
}
