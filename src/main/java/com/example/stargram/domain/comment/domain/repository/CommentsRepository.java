package com.example.stargram.domain.comment.domain.repository;

import com.example.stargram.domain.comment.domain.Comments;
import org.springframework.data.repository.CrudRepository;


public interface CommentsRepository extends CrudRepository<Comments, Long> {

}
