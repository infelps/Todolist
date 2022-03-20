package com.example.todolist.dto;

import com.example.todolist.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;

    public UserDto(User entity){
        this.username=entity.getUsername();
        this.password=entity.getPassword();
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
