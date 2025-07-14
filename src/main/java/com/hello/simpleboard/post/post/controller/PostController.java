package com.hello.simpleboard.post.post.controller;

import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/{boardId}/posts")
    public ResponseEntity<CreatePost.Response> createPost(@RequestBody CreatePost.Request request,
                                                          @PathVariable Long boardId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postService.createPost(request, boardId));
    }
}
