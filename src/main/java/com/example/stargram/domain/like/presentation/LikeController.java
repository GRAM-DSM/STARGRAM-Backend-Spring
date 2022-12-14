package com.example.stargram.domain.like.presentation;


import com.example.stargram.domain.like.presentation.dto.response.LikeResponse;
import com.example.stargram.domain.like.service.AddHeartService;
import com.example.stargram.domain.like.service.CancelHeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("feeds/likes")
@RequiredArgsConstructor
@RestController
public class LikeController {
    private final AddHeartService addHeartService;
    private final CancelHeartService cancelHeartService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public LikeResponse addHeart(@PathVariable("feed-id") UUID feedId) {
        return addHeartService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public LikeResponse deleteHeart(@PathVariable("feed-id") UUID feedId) {
        return cancelHeartService.execute(feedId);
    }
}
