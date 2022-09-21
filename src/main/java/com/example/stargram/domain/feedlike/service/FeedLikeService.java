package com.example.stargram.domain.feedlike.service;


import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.feedlike.domain.FeedLike;
import com.example.stargram.domain.feedlike.domain.repository.FeedLikeRepository;
import com.example.stargram.domain.feedlike.exception.LikeAlreadyExistsException;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FeedLikeService {
    private final FeedLike feedLike;

    private final UserFacade userFacade;

    private final FeedLikeRepository feedLikeRepository;

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);

        if(feedLike.getUser().equals(user)){
            throw LikeAlreadyExistsException.EXCEPTION;
        }

        feedLikeRepository.save(
                FeedLike.builder()
                        .user(user)
                        .feed(feed)
                        .build()
        );

    }
}
