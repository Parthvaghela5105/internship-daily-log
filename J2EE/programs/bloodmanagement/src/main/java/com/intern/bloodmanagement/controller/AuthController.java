package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.AuthRequest;
import com.intern.bloodmanagement.proxy.AuthResponse;
import com.intern.bloodmanagement.proxy.ForgetPassword;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserProxy userProxy){
        return new ResponseEntity<>(authService.register(userProxy) , HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request){
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/forget")
    public ResponseEntity<String> login(@Valid @RequestBody ForgetPassword forgetPassword){
        return new ResponseEntity<>(authService.forgetPassword(forgetPassword) , HttpStatus.OK);
    }
}
