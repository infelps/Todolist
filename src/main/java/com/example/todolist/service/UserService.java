package com.example.todolist.service;

import com.example.todolist.domain.User;
import com.example.todolist.domain.UserRepository;
import com.example.todolist.dto.SignupDto;
import com.example.todolist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDto userDto){
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public User login(UserDto userDto){
        User user = userRepository.findByUsername(userDto.getUsername());
        if(user!=null && user.getPassword().equals(userDto.getPassword())){
            return user;
        }
        return null;
    }

    public Boolean signup(SignupDto signupDto){
        User user = userRepository.findByUsername(signupDto.getUsername());
        if(user==null && signupDto.getPassword().equals(signupDto.getConfirmPassword())){
            userRepository.save(signupDto.toEntity());
            return true;
        }else{
            return false;
        }
    }
}
