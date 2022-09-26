package com.example.stargram.domain.comment.service;


import com.example.stargram.domain.comment.domain.Comments;
import com.example.stargram.domain.comment.domain.repository.CommentsRepository;
import com.example.stargram.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCommentsService {

    private final CommentsRepository commentRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateCommentRequest createCommentRequest) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(createCommentRequest.getFeedUuid())
                .orElseThrow(RuntimeException::new);

        Comments comments = Comments.builder()
                .user(user)
                .feed(feed)
                .content(createCommentRequest.getContent())
                .build();
        commentRepository.save(comments);

    }
}
