package com.hello.simpleboard.service;

import com.hello.simpleboard.dto.PostBoard;
import com.hello.simpleboard.dto.PutBoard;
import com.hello.simpleboard.entity.Board;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    public Board save(PostBoard.Request request) {
        return boardRepository.save(
                    Board.of(
                        request.getTitle(),
                        request.getDescription(),
                        request.getWriter(),
                        LocalDate.now()
                    )
        );
    }

    public Board getBoard(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow();
    }

    @Override
    @Transactional
    public Board updateBoard(Long id, PutBoard.Request request) {
        Board board = boardRepository.findById(id).orElseThrow();
        return board.update(
                request.getTitle(),
                request.getDescription(),
                request.getWriter(),
                LocalDate.now()
        );
    }
}
