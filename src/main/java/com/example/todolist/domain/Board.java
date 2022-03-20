package com.example.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int checked;

    @Builder
    public Board(Long id, String content,int checked){
        this.id=id;
        this.content=content;
        this.checked=checked;
    }

    public void updateContent(String content){
        this.content=content;
    }

    public void updateChecked(int checked){
        this.checked=checked;
    }


}
