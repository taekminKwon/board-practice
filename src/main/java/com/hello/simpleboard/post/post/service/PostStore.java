package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.entity.Post;

public interface PostStore {
    CreatePost.Response store(Post of, Long boardId);
}
