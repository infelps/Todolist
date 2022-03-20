package com.example.todolist.controller;

import com.example.todolist.domain.Board;
import com.example.todolist.dto.BoardDto;
import com.example.todolist.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping("/api/board/{id}")
    public BoardDto findById(@PathVariable Long id){
        return boardService.findById(id);
    }

    @PostMapping("/api/board/")
    public void save(@RequestBody BoardDto boardDto){
        boardService.save(boardDto);
    }

    @PutMapping("/api/board/{id}")
    public void updateBoardContent(@PathVariable Long id, @RequestBody BoardDto boardDto){
        boardService.updateBoardContent(id,boardDto);
    }

    @PutMapping("/api/board/checked/{id}")
    public void updateBoardChecked(@PathVariable Long id){
        boardService.updateBoardChecked(id);
    }

    @DeleteMapping("/api/board/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}
