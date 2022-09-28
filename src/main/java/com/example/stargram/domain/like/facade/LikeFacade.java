package com.example.stargram.domain.like.facade;

import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.like.domain.repository.LikeRepository;
import com.example.stargram.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {
    private final LikeRepository likeRepository;

    public boolean confirmLike(User user, Feed feed) {
        return likeRepository.existsById(user, feed);
    }
}
