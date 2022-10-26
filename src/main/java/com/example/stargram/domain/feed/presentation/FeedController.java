package com.example.stargram.domain.feed.presentation;

import com.example.stargram.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.stargram.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.stargram.domain.feed.presentation.dto.response.FeedGetResponse;
import com.example.stargram.domain.feed.service.CreateFeedService;
import com.example.stargram.domain.feed.service.DeleteFeedService;
import com.example.stargram.domain.feed.service.FeedGetService;
import com.example.stargram.domain.feed.service.UpdateFeedService;
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
    private final UpdateFeedService updateFeedService;
    private final FeedGetService feedGetService;

    @GetMapping("/list")
    public FeedGetResponse getFeed() {
        return feedGetService.execute();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable UUID id) {
        deleteFeedService.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateFeed(@PathVariable UUID id, @RequestBody UpdateFeedRequest request) {
        updateFeedService.execute(id, request);
    }

}
