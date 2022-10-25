package com.example.stargram.domain.feed.service;


import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.presentation.dto.response.FeedGetResponse;
import com.example.stargram.domain.image.domain.Image;
import com.example.stargram.domain.like.facade.LikeFacade;
import com.example.stargram.domain.profile.domain.Profile;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.entity.BaseTimeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedGetService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public FeedGetResponse execute() {
        User user = userFacade.getCurrentUser();
        List<FeedGetResponse.FeedResponse> feedResponseList = feedRepository.findAllByJoinFetch()
                .stream()
                .map(this::feedList)
                .collect(Collectors.toList());
        return new FeedGetResponse(feedResponseList);
    }

    private FeedGetResponse.FeedResponse feedList(Feed feed, User user, BaseTimeEntity baseTimeEntity, Profile profile, Image image) {
        return FeedGetResponse.FeedResponse.builder()
                .feedUuid(feed.getId())
                .title(feed.getTitle())
                .heartCount(feed.getHeartCount())
                .commentCount(feed.getCommentCount())
                .createAt(baseTimeEntity.getCreateAt())
                .name(profile.getName())
                .image(image.getUrl())
                .heartType(likeFacade.confirmHeart(user, feed))
                .build();
    }

}
