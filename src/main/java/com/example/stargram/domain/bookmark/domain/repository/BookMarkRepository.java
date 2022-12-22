package com.example.stargram.domain.bookmark.domain.repository;

import com.example.stargram.domain.bookmark.domain.BookMark;
import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
    void deleteByUserAndFeed(User user, Feed feed);
    boolean existsByUserAndFeed(User user, Feed feed);
}
