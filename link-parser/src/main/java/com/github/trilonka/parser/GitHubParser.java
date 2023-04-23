package com.github.trilonka.parser;

import com.github.trilonka.response.BaseResponse;
import com.github.trilonka.response.GitHubResponse;

import java.util.Optional;
import java.util.regex.Pattern;

public class GitHubParser extends LinkChainParser {

    private static final Pattern USER_REPO_PATTERN = Pattern.compile("^https://github.com/([\\w.-]+)/([\\w.-]+)(/|$)");

    @Override
    public Optional<BaseResponse> parse(String link) {
        var matcher = USER_REPO_PATTERN.matcher(link);
        if (matcher.find()) {
            String username = matcher.group(1);
            String repository = matcher.group(2);
            return Optional.of(new GitHubResponse(username, repository));
        }
        return parseNext(link);
    }
}
