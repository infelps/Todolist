package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.dto.SignupDto;
import com.example.todolist.dto.UserDto;
import com.example.todolist.service.BoardService;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, HttpServletRequest request){
        User loginUser = userService.login(userDto);
        if(loginUser==null){
            return "redirect:/";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginUser",loginUser);
        System.out.println("board");
        return "redirect:/board";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupGet(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute SignupDto signupDto){
        userService.signup(signupDto);
        return "redirect:/";
    }
}
