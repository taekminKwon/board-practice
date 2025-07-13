package com.hello.simpleboard.service;

import com.hello.simpleboard.dto.PostBoard;
import com.hello.simpleboard.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardServiceImplTest {
    @Autowired
    private BoardService boardService;

    @Test
    void save() {
        //given
        PostBoard.Request request = PostBoard.Request.of("자유게시판", "자유게시판입니다","운영자");

        //when
        Board saved = boardService.save(request);
        Board found = boardService.getBoard(saved.getId());

        //then
        assertThat(saved).usingRecursiveComparison().isEqualTo(found);
    }
}