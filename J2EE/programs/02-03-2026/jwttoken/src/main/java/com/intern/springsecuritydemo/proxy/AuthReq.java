package com.intern.springsecuritydemo.proxy;

import lombok.Data;

@Data
public class AuthReq {
    private String username;
    private String password;
}
