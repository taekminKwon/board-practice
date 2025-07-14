package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.post.post.entity.Post;

public interface PostReader {
    Post readPost(Long postId);
}
