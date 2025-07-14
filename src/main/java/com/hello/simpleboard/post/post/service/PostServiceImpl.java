package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.board.entity.Board;
import com.hello.simpleboard.board.service.BoardRepository;
import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostStore postStore;
    private final BoardRepository boardRepository;

    @Override
    public CreatePost.Response createPost(CreatePost.Request request, Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        return postStore.store(Post.of(request, board), boardId);
    }
}
