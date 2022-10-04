package com.example.stargram.domain.bookmark.presentation;


import com.example.stargram.domain.bookmark.service.DeleteBookMarkService;
import com.example.stargram.domain.bookmark.service.PostBookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/feeds/bookmark")
@RequiredArgsConstructor
@RestController
public class BookMarkController {
    private final PostBookMarkService postBookMarkService;
    private final DeleteBookMarkService deleteBookMarkService;

    @PostMapping("/{feed-id}")
    public void postBookMark(@PathVariable("feed-id") UUID feedId) {
        postBookMarkService.execute(feedId);
    }

    @DeleteMapping("/{bookmark-id}")
    public void deleteBookMark(@PathVariable("bookmark-id")Long bookmarkId) {
        deleteBookMarkService.execute(bookmarkId);
    }
}
