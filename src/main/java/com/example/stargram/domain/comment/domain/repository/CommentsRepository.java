package com.example.stargram.domain.comment.domain.repository;

import com.example.stargram.domain.comment.domain.Comments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CommentsRepository extends CrudRepository<Comments, Long> {

    List<Comments> findAllByFeedId(UUID id);
}
