package com.hello.simpleboard.dto;

import com.hello.simpleboard.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class PutBoard {
    @Getter
    @NoArgsConstructor
    public static class Request {
        private String title;
        private String description;
        private String writer;

        public static Request of(String title, String description, String writer) {
            Request request = new Request();
            request.title = title;
            request.description = description;
            request.writer = writer;
            return request;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String description;
        private String writer;
        private LocalDate date;

        public static Response of(Board board) {
            Response response = new Response();
            response.id = board.getId();
            response.title = board.getTitle();
            response.description = board.getDescription();
            response.writer = board.getWriter();
            response.date = board.getDate();
            return response;
        }
    }
}
