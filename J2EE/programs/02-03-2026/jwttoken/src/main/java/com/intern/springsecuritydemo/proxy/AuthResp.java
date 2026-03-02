package com.intern.springsecuritydemo.proxy;

import lombok.Data;

@Data
public class AuthResp {
    private String token;
    private String username;
}
