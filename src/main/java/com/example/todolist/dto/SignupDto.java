package com.example.todolist.dto;

import com.example.todolist.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String username;
    private String password;
    private String confirmPassword;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
