package com.hello.simpleboard.service;

import com.hello.simpleboard.dto.PostBoard;
import com.hello.simpleboard.dto.PutBoard;
import com.hello.simpleboard.entity.Board;

public interface BoardService {
    Board save(PostBoard.Request request);
    Board getBoard(Long boardId);
    Board updateBoard(Long id, PutBoard.Request request);
}
