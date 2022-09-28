package com.example.stargram.domain.like.service;


import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.facade.FeedFacade;
import com.example.stargram.domain.like.domain.repository.LikeRepository;
import com.example.stargram.domain.like.facade.LikeFacade;
import com.example.stargram.domain.like.presentation.dto.response.LikeResponse;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public LikeResponse execute(UUID feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(feedId);

        if(likeFacade.confirmLike(user, feed)) {
            throw ?
        }

        return addLike(user, feed);
    }

    private LikeResponse addLike(User user, Feed feed) {

    }
}
