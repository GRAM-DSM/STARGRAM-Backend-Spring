package com.example.stargram.domain.feed.service;



import com.example.stargram.domain.comment.domain.repository.CommentsRepository;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.exception.FeedNotFoundException;
import com.example.stargram.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.stargram.domain.image.domain.Image;
import com.example.stargram.domain.image.domain.repository.ImageRepository;
import com.example.stargram.domain.like.facade.LikeFacade;
import com.example.stargram.domain.profile.domain.Profile;
import com.example.stargram.domain.profile.domain.repository.ProfileRepository;
import com.example.stargram.domain.profile.exception.ProfileNotFoundException;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedGetDetailService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;
    private final CommentsRepository commentsRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse.FeedGetDetailResponse execute(UUID id) {
        User user = userFacade.getCurrentUser();
        Profile profile = profileRepository.findByUserId(user.getId()).orElseThrow(() -> ProfileNotFoundException.EXCEPTION);
        return feedRepository.findById(id)
                .map(feed -> {
                    FeedDetailResponse.FeedGetDetailResponse feedGetDetailResponse = FeedDetailResponse.FeedGetDetailResponse.builder()
                            .feedUuid(feed.getId())
                            .profileImage(profile.getPhoto())
                            .name(profile.getName())
                            .title(feed.getTitle())
                            .content(feed.getContent())
                            .createAt(feed.getCreateAt())
                            .category(feed.getCategory())
                            .heartCount(feed.getHeartCount())
                            .commentCount(feed.getCommentCount())
                            .favorite(likeFacade.confirmHeart(user, feed))
                            .images(imageRepository.findAllByFeedId(feed.getId()).stream().map(Image::getUrl).collect(Collectors.toList()))
                            .comments(commentsRepository.findAllByFeedId(feed.getId()).stream().map(comments -> FeedDetailResponse.CommentsResponse.builder()
                                    .commentId(comments.getId())
                                    .profileImage(profileRepository.findByUserId(feed.getUser().getId()).orElseThrow(() -> ProfileNotFoundException.EXCEPTION).getPhoto())
                                    .content(comments.getContent())
                                    .name(profile.getName())
                                    .build()).collect(Collectors.toList()))
                            .build();
                    return feedGetDetailResponse;
                })
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

    }
}


