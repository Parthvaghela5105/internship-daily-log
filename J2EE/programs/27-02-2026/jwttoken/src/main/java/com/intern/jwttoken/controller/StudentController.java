package com.intern.jwttoken.controller;

import com.intern.jwttoken.proxy.LoginRequestProxy;
import com.intern.jwttoken.proxy.LoginResponseProxy;
import com.intern.jwttoken.proxy.SignUpResponseProxy;
import com.intern.jwttoken.proxy.StudentProxy;
import com.intern.jwttoken.service.implemantation.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/v1/student")
public class StudentController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseProxy> login(@RequestBody LoginRequestProxy loginRequestProxy){
        return new ResponseEntity<>(authService.login(loginRequestProxy), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseProxy> signup(@RequestBody StudentProxy studentProxy){
        return new ResponseEntity<>(authService.signup(studentProxy), HttpStatus.OK);
    }
}
