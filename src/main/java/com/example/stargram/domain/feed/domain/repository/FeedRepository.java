package com.example.stargram.domain.feed.domain.repository;

import com.example.stargram.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
