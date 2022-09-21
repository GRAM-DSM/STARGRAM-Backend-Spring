package com.example.stargram.domain.feedlike.presentation;

import com.example.stargram.domain.feedlike.service.FeedLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds/likes")
@RestController
public class FeedLikeController {

    private final FeedLikeService feedLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@PathVariable UUID id) {
        feedLikeService.execute(id);
    }

}
