package com.example.stargram.domain.comment.presentation;

import com.example.stargram.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.stargram.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.example.stargram.domain.comment.service.CreateCommentsService;
import com.example.stargram.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/feeds/comments")
@RequiredArgsConstructor
@RestController
public class CommentsController {

    private final CreateCommentsService createCommentService;
    private final UpdateCommentService updateCommentService;

    @PostMapping("/{id}")
    public void create(@RequestBody CreateCommentRequest createCommentRequest, @PathVariable UUID id) {
        createCommentService.execute(createCommentRequest, id);

    }

    @PatchMapping("/{id}")
    public void update(@RequestBody UpdateCommentRequest updateCommentRequest, @PathVariable Long id) {
        updateCommentService.execute(updateCommentRequest, id);
    }
}
