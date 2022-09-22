package com.example.stargram.domain.comment.service;


import com.example.stargram.domain.comment.domain.Comments;
import com.example.stargram.domain.comment.domain.repository.CommentsRepository;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class DeleteCommentsService {

   private final CommentsRepository commentsRepository;
   private final UserFacade userFacade;

   @Transactional
   public void execute(Long id) {
      User user = userFacade.getCurrentUser();

      Comments comments = commentsRepository.findById(id).orElseThrow(RuntimeException::new);

      if(!comments.getUser().equals(user)){
         throw InvalidRoleException.EXCEPTION;
      }

      commentsRepository.delete(comments);
   }
}
