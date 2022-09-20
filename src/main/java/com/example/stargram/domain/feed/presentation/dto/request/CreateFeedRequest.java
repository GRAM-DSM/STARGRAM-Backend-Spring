package com.example.stargram.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    private String title;

    private String content;

    private String category;

}
