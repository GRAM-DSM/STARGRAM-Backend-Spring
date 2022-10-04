package com.example.stargram.domain.bookmark.service;

import com.example.stargram.domain.bookmark.domain.BookMark;
import com.example.stargram.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostBookMarkService {

    private final FeedRepository feedRepository;
    private final BookMarkRepository bookMarkRepository;
    private final UserFacade userFacade;


    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        BookMark bookMark = BookMark.builder()
                .feed(feed)
                .user(user)
                .build();
        bookMarkRepository.save();
    }

}
