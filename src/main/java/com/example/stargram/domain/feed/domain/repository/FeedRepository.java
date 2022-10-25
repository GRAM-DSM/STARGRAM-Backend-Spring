package com.example.stargram.domain.feed.domain.repository;

import com.example.stargram.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FeedRepository extends CrudRepository<Feed, UUID> {

    @Query
    List<Feed> findAllByJoinFetch();
}
