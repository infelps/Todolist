package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String Index(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session==null){
            return "index";
        }
        User loginUser = (User) session.getAttribute("loginUser");

        if(loginUser==null){
            return "index";
        }
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String Board(Model model){
        model.addAttribute("boards",boardService.findAll());
        return "board";
    }
}
