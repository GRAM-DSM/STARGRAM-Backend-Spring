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
public class FeedDetailResponse {

    @Getter
    @Builder
    public static class FeedGetDetailResponse {
        private UUID feedUuid;

        private String profileImage;

        private String name;

        private String title;

        private String content;

        private ZonedDateTime createAt;

        private String category;

        private int heartCount;

        private int commentCount;

        private boolean favorite;

        private List<String> images;

        private List<CommentsResponse> comments;
    }

    @Getter
    @Builder
    public static class CommentsResponse {
        private Long commentId;

        private String profileImage;

        private String name;

        private String content;

        private ZonedDateTime createAt;
    }


}
