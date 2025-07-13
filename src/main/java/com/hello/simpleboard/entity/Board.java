package com.hello.simpleboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "time")
    private LocalDate date;

    public static Board of(
            String title,
            String description,
            String writer,
            LocalDate date
    ) {
        Board board = new Board();
        board.title = title;
        board.description = description;
        board.writer = writer;
        board.date = date;
        return board;
    }
}
