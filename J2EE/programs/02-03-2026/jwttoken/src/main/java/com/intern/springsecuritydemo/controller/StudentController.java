package com.intern.springsecuritydemo.controller;

import com.intern.springsecuritydemo.proxy.AuthReq;
import com.intern.springsecuritydemo.proxy.AuthResp;
import com.intern.springsecuritydemo.proxy.StudentProxy;
import com.intern.springsecuritydemo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

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

    @GetMapping(value = "/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    @PostMapping(value = "/save-student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentProxy studentProxy){
        return new ResponseEntity<>(studentService.saveStudent(studentProxy) , HttpStatus.CREATED);
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<AuthResp> login(@RequestBody AuthReq authReq){
        AuthResp authResp = studentService.authenticateStudent(authReq);
        return new ResponseEntity<>(authResp , HttpStatus.OK);
    }

}
