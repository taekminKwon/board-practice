package com.hello.simpleboard.post.post.dto;

import com.hello.simpleboard.post.post.entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class CreatePost {
    @Getter
    @NoArgsConstructor
    public static class Request {
        private String title;
        private String content;
        private String writer;
        public static Request of (
                String title,
                String content,
                String writer
        ) {
            Request request = new Request();
            request.title = title;
            request.content = content;
            request.writer = writer;
            return request;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Response {
        private Long id;
        private Long boardId;
        private String title;
        private String content;
        private String writer;
        private LocalDate time;

        public static Response of(Post post, Long boardId) {
            Response response = new Response();
            response.id = post.getId();
            response.boardId = boardId;
            response.title = post.getTitle();
            response.content = post.getContent();
            response.writer = post.getWriter();
            response.time = LocalDate.now();
            return response;
        }
    }
}
