package com.example.stargram.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class FeedGetResponse {

    private final List<FeedResponse> feedResponseList;

    @Getter
    @Builder
    public static class FeedResponse {

        UUID feedUuid;
        String name;
        String title;
        ZonedDateTime createAt;
        int heartCount;
        int commentCount;
        String image;
        boolean heartType;
    }

}
