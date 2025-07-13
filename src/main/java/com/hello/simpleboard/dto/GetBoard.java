package com.hello.simpleboard.dto;

import com.hello.simpleboard.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public class GetBoard {
    @NoArgsConstructor
    @Getter
    public static class Response {
        private Long id;
        private String title;
        private String description;
        private String writer;
        private LocalDate localDate;

        public static Response of(Board board) {
            Response response = new Response();
            response.id = board.getId();
            response.title = board.getTitle();
            response.description = board.getDescription();
            response.writer = board.getWriter();
            response.localDate = board.getDate();
            return response;
        }
    }
}
