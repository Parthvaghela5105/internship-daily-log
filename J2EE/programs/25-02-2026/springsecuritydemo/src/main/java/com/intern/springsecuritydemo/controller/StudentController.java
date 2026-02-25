package com.intern.springsecuritydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {
    @GetMapping(value = "/secure")
    public String checkSecurity(){
        return "Secure webpage";
    }

    @PostMapping(value = "/verify")
    public String verifyWebPage(){
        return "Verify user";
    }

    @GetMapping(value = "/session")
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    @GetMapping(value = "csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

}
