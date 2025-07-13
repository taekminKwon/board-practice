package com.hello.simpleboard.board.controller;

import com.hello.simpleboard.board.dto.GetBoard;
import com.hello.simpleboard.board.dto.PostBoard;
import com.hello.simpleboard.board.dto.PutBoard;
import com.hello.simpleboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @PostMapping
    public ResponseEntity<PostBoard.Response> postBoard(@RequestBody PostBoard.Request request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PostBoard.Response.of(boardService.save(request)));
    }

    @GetMapping
    public ResponseEntity<GetBoard.Response> getBoard(@RequestParam Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GetBoard.Response.of(boardService.getBoard(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutBoard.Response> putBoard(
            @RequestBody PutBoard.Request request, @PathVariable Long id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PutBoard.Response.of(boardService.updateBoard(id, request)));
    }
}
