package com.example.stargram.domain.bookmark.service;

import com.example.stargram.domain.bookmark.domain.BookMark;
import com.example.stargram.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.feed.facade.FeedFacade;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class DeleteBookMarkService {
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final BookMarkRepository bookMarkRepository;

    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(id);

        if (!feed.getUser().equals(user)) {
            throw InvalidRoleException.EXCEPTION;
        }

        bookMarkRepository.deleteByUserAndFeed(user, feed);

    }
}
