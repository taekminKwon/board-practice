package com.hello.simpleboard.post.post.service;

import com.hello.simpleboard.board.dto.PostBoard;
import com.hello.simpleboard.board.entity.Board;
import com.hello.simpleboard.board.service.BoardService;
import com.hello.simpleboard.post.post.dto.CreatePost;
import com.hello.simpleboard.post.post.dto.GetPost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PostServiceImplTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    private static Board savedBoard;
    @BeforeEach
    void setUp() {
        PostBoard.Request request = PostBoard.Request.of("자유게시판", "자유게시판입니다","운영자");
        savedBoard = boardService.save(request);
    }

    @Test
    void createPost() {
        //given
        CreatePost.Request given = CreatePost.Request.of("제목", "내용", "글쓴이");

        //when
        CreatePost.Response saved = postService.createPost(given, savedBoard.getId());
        GetPost.Response found = postService.getPost(saved.getBoardId(), saved.getId());

        //then

        Assertions.assertThat(saved.getId()).isEqualTo(found.getId());
        Assertions.assertThat(saved.getBoardId()).isEqualTo(found.getBoardId());
        Assertions.assertThat(saved.getTitle()).isEqualTo(found.getTitle());
        Assertions.assertThat(saved.getContent()).isEqualTo(found.getContent());
        Assertions.assertThat(saved.getWriter()).isEqualTo(found.getWriter());
        Assertions.assertThat(saved.getTime()).isEqualTo(found.getTime());
    }
}