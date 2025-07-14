package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.dto.GetPost;

public interface PostService {
    CreatePost.Response createPost(CreatePost.Request request, Long boardId);

    GetPost.Response getPost(Long boardId, Long postId);
}
