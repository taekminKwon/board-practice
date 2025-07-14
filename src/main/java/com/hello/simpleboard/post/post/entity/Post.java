package com.hello.simpleboard.post.post.entity;

import com.hello.simpleboard.board.entity.Board;
import com.hello.simpleboard.post.post.dto.CreatePost;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content")
    @Lob
    private String content;

    //TODO : 나중에 User 객체로 변경 예정
    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "time")
    private LocalDate date;

    public static Post of(CreatePost.Request request, Board board) {
        Post post = new Post();
        post.board = board;
        post.title = request.getTitle();
        post.content = request.getContent();
        post.writer = request.getWriter();
        post.date = LocalDate.now();
        return post;
    }
}
