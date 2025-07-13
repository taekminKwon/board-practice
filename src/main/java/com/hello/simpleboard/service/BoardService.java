package com.hello.simpleboard.service;

import com.hello.simpleboard.dto.GetBoard;
import com.hello.simpleboard.dto.PostBoard;
import com.hello.simpleboard.entity.Board;

public interface BoardService {
    Board save(PostBoard.Request request);
    Board getBoard(Long boardId);
}
