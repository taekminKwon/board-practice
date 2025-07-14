package com.hello.simpleboard.post.post.infrastructure;

import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.entity.Post;
import com.hello.simpleboard.post.post.service.PostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostStoreImpl implements PostStore {
    private final PostRepository postRepository;

    @Override
    public CreatePost.Response store(Post post, Long boardId) {
        return CreatePost.Response.of(postRepository.save(post), boardId);
    }
}
