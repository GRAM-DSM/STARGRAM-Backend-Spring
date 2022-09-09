package com.example.stargram.domain.comment.presentation.dto.request;


import com.example.stargram.domain.feed.domain.Feed;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    private Feed feed;

    private String content;
}
