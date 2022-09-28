package com.example.stargram.domain.like.domain.repository;

import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.like.domain.Like;
import com.example.stargram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsById(User user, Feed feed);
}
