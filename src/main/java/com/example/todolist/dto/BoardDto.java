package com.example.todolist.dto;

import com.example.todolist.domain.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long id;
    private String content;
    private int checked;
    private Boolean boxChecked=false;

    public BoardDto(Board entity){
        this.id=entity.getId();
        this.content=entity.getContent();
        this.checked=entity.getChecked();
    }
}
