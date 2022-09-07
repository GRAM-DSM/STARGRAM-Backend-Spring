package com.example.stargram.domain.feed.presentation;

import com.example.stargram.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.stargram.domain.feed.service.CreateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

}
