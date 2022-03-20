package com.example.todolist.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
        HttpSession session = request.getSession(false);
        if(session==null || session.getAttribute("loginUser")==null){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
