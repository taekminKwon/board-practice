package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.post.post.dto.CreatePost;

public interface PostService {
    CreatePost.Response createPost(CreatePost.Request request, Long boardId);
}
