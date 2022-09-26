package com.example.stargram.domain.comment.service;


import com.example.stargram.domain.comment.domain.Comments;
import com.example.stargram.domain.comment.domain.repository.CommentsRepository;
import com.example.stargram.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
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
    public void execute(UpdateCommentRequest request, Long id) {
        User user = userFacade.getCurrentUser();

        if (feedRepository.existsById(request.getFeedUuid())) {
            throw FeedNotFoundException.EXCEPTION;
        }

        Comments comments = commentsRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        if (!comments.getUser().equals(user)) {
            throw InvalidRoleException.EXCEPTION;
        }

        comments.updateComments(request.getContent());
    }
}
