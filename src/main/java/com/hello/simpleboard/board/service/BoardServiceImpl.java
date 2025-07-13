package com.hello.simpleboard.board.service;

import com.hello.simpleboard.board.dto.PostBoard;
import com.hello.simpleboard.board.dto.PutBoard;
import com.hello.simpleboard.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Transactional
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

    @Transactional(readOnly = true)
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
