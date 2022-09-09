package com.example.stargram.domain.feed.presentation;

import com.example.stargram.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.stargram.domain.feed.service.CreateFeedService;
import com.example.stargram.domain.feed.service.DeleteFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFeed(@PathVariable UUID id) {
        deleteFeedService.execute(id);
    }
    
}
