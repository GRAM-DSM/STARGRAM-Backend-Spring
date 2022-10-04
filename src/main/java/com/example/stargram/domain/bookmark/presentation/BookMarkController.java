package com.example.stargram.domain.bookmark.presentation;


import com.example.stargram.domain.bookmark.service.PostBookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/feeds/bookmark")
@RequiredArgsConstructor
@RestController
public class BookMarkController {
    private final PostBookMarkService postBookMarkService;

    @PostMapping("/{feed-id}")
    public void postBookMark(@PathVariable("feed-id") UUID feedId) {
        postBookMarkService.execute(feedId);
    }
}
