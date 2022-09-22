package com.example.stargram.domain.comment.presentation.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    private UUID FeedUuid;
    private String content;
}
