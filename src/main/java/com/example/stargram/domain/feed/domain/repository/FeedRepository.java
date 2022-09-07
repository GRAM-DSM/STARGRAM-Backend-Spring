package com.example.stargram.domain.feed.domain.repository;

import com.example.stargram.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FeedRepository extends CrudRepository<Feed, UUID> {
}
