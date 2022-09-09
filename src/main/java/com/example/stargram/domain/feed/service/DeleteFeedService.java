package com.example.stargram.domain.feed.service;


import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(UUID id) {
        feedRepository.deleteById(id);
    }
}
