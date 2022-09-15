package com.example.stargram.domain.feed.service;

import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.feed.presentation.dto.request.UpdateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(UUID id, UpdateFeedRequest updateFeedRequest) {
        Feed feed = feedRepository.findById(id)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);
        feed.updateFeed(updateFeedRequest.getTitle(), updateFeedRequest.getContent());
        }
    }

