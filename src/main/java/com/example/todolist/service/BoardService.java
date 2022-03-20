package com.example.todolist.service;

import com.example.todolist.domain.Board;
import com.example.todolist.domain.BoardRepository;
import com.example.todolist.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> findAll(){
        List<BoardDto> boardDtoList=boardRepository.findAll(Sort.by("id")).stream().map(BoardDto::new).collect(Collectors.toList());
        for(BoardDto boardDto : boardDtoList){
            if(boardDto.getChecked()==1){
                boardDto.setBoxChecked(true);
            }
        }
        return boardDtoList;
    }

    public BoardDto findById(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new BoardDto(board);
    }

    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        boardRepository.delete(board);
    }

    public void updateBoardContent(Long id,BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        if(board!=null){
            board.updateContent(boardDto.getContent());
        }
    }

    public void updateBoardChecked(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        if(board!=null){
            board.updateChecked((board.getChecked()==1)?0:1);
            boardRepository.save(board);
        }
    }

    public void save(BoardDto boardDto){
        Board board = Board.builder().content(boardDto.getContent()).build();
        boardRepository.save(board);
    }


}
