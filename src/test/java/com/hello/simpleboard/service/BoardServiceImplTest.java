package com.hello.simpleboard.service;

import com.hello.simpleboard.dto.PostBoard;
import com.hello.simpleboard.dto.PutBoard;
import com.hello.simpleboard.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
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

    @Test
    void update() {
        //given
        PostBoard.Request request = PostBoard.Request.of("자유게시판", "자유게시판입니다","운영자");
        Board saved = boardService.save(request);
        PutBoard.Request updateRequest = PutBoard.Request.of("공지사항", "공지사항입니다","운영자");

        //when
        Board updated = boardService.updateBoard(saved.getId(), updateRequest);
        Board found = boardService.getBoard(saved.getId());

        //then
        assertThat(updated).usingRecursiveComparison().isEqualTo(found);
        assertThat(updated.getId()).isEqualTo(saved.getId());
        assertThat(updated.getTitle()).isEqualTo("공지사항");
        assertThat(updated.getDescription()).isEqualTo("공지사항입니다");
        assertThat(updated.getWriter()).isEqualTo("운영자");
    }
}