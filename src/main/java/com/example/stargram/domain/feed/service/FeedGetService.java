package com.example.stargram.domain.feed.service;


import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.presentation.dto.response.FeedGetResponse;
import com.example.stargram.domain.image.domain.Image;
import com.example.stargram.domain.image.domain.repository.ImageRepository;
import com.example.stargram.domain.image.exception.ImageNotFoundException;
import com.example.stargram.domain.like.facade.LikeFacade;
import com.example.stargram.domain.profile.domain.Profile;
import com.example.stargram.domain.profile.domain.repository.ProfileRepository;
import com.example.stargram.domain.profile.exception.ProfileNotFoundException;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.entity.BaseTimeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedGetService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public FeedGetResponse execute() {
        User user = userFacade.getCurrentUser();
        Profile profile = profileRepository.findByUserId(user.getId()).orElseThrow(() -> ProfileNotFoundException.EXCEPTION);
        List<FeedGetResponse.FeedResponse> feedResponseList = feedRepository.findAllByJoinFetch()
                .stream()
                .map(feed -> {
                    FeedGetResponse.FeedResponse feedResponse = FeedGetResponse.FeedResponse.builder()
                            .feedUuid(feed.getId())
                            .title(feed.getTitle())
                            .heartCount(feed.getHeartCount())
                            .commentCount(feed.getCommentCount())
                            .createAt(feed.getCreateAt())
                            .name(profile.getName())
                            .image(imageRepository.findAllByFeed_Id(feed.getId()).stream().map(Image::getUrl).collect(Collectors.toList()))
                            .heartType(likeFacade.confirmHeart(user,feed))
                            .build();
                    return feedResponse;
                })
                .collect(Collectors.toList());
        return new FeedGetResponse(feedResponseList);

    }

}
