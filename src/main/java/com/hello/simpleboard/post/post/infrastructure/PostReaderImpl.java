package com.hello.simpleboard.post.post.infrastructure;

import com.hello.simpleboard.post.post.entity.Post;
import com.hello.simpleboard.post.post.service.PostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReaderImpl implements PostReader {
    private final PostRepository postRepository;

    @Override
    public Post readPost(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }
}
