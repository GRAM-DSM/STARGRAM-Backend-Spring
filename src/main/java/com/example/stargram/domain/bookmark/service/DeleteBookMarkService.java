package com.example.stargram.domain.bookmark.service;

import com.example.stargram.domain.bookmark.domain.BookMark;
import com.example.stargram.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class DeleteBookMarkService {
    private final UserFacade userFacade;
    private final BookMarkRepository bookMarkRepository;
    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();

        BookMark bookMark = bookMarkRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        if (!bookMark.getUser().equals(user)) {
            throw InvalidRoleException.EXCEPTION;
        }

        bookMarkRepository.delete(bookMark);
    }
}
