package com.example.stargram.domain.feed.service;

import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.feed.domain.repository.FeedRepository;
import com.example.stargram.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.stargram.domain.image.domain.Image;
import com.example.stargram.domain.image.domain.repository.ImageRepository;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final ImageRepository imageRepository;

    @Transactional
    public void execute(CreateFeedRequest createFeedRequest) {
        User user = userFacade.getCurrentUser();

        Feed feed = Feed.builder()
                .title(createFeedRequest.getTitle())
                .user(user)
                .category(createFeedRequest.getCategory())
                .content(createFeedRequest.getContent())
                .build();
        feedRepository.save(feed);

        for (String i : createFeedRequest.getUrl()) {
            Image image = Image.builder()
                    .feed(feed)
                    .url(i)
                    .build();
            imageRepository.save(image);
        }
    }
}
