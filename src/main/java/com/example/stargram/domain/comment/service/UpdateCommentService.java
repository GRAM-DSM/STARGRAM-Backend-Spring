package com.example.stargram.domain.comment.service;


import com.example.stargram.domain.comment.domain.Comments;
import com.example.stargram.domain.comment.domain.repository.CommentsRepository;
import com.example.stargram.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateCommentService {

    private final CommentsRepository commentsRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateCommentRequest updateCommentRequest, Long id) {
        Comments comments = commentsRepository.findById(id).orElseThrow(RuntimeException::new);
        Feed feed = feedRepository.findById(updateCommentRequest.getFeedUuid()).orElseThrow(RuntimeException::new);

        User user = userFacade.getCurrentUser();

        if(!comments.getUser().equals(user)){
            throw InvalidRoleException.EXCEPTION;
        }

        comments.updateComments(updateCommentRequest.getContent());
    }
}
