package com.intern.tailorshop.controller;

import com.intern.tailorshop.proxy.CreateUserRequest;
import com.intern.tailorshop.proxy.LoginRequestProxy;
import com.intern.tailorshop.proxy.LoginResponseProxy;
import com.intern.tailorshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody CreateUserRequest createUserRequest){
        String user = authService.createUser(createUserRequest);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PostMapping(value = "/create-shop-admin")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<String> createShopAdmin(@RequestBody CreateUserRequest createUserRequest){
        String user = authService.createShopAdmin(createUserRequest);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseProxy> login(@RequestBody LoginRequestProxy loginRequestProxy){
        LoginResponseProxy loginResponseProxy = authService.loginUser(loginRequestProxy);
        return new ResponseEntity<>(loginResponseProxy , HttpStatus.OK);
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<String> admin(){
        return new ResponseEntity<>("You are admin" , HttpStatus.OK);
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<String> customer(){
        return new ResponseEntity<>("You are customer" , HttpStatus.OK);
    }

    @GetMapping(value = "/customer&Admin")
    public ResponseEntity<String> customerAndAdmin(){
        return new ResponseEntity<>("You are customer and Admin" , HttpStatus.OK);
    }

}
