package com.hello.simpleboard.board.service;

import com.hello.simpleboard.board.dto.PostBoard;
import com.hello.simpleboard.board.dto.PutBoard;
import com.hello.simpleboard.board.entity.Board;

public interface BoardService {
    Board save(PostBoard.Request request);
    Board getBoard(Long boardId);
    Board updateBoard(Long id, PutBoard.Request request);
}
