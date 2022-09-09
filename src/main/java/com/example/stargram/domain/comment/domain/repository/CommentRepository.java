package com.example.stargram.domain.comment.domain.repository;

import com.example.stargram.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {

}
