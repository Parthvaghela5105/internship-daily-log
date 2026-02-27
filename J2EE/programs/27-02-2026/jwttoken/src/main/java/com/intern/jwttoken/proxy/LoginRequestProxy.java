package com.intern.jwttoken.proxy;

import lombok.Data;

@Data
public class LoginRequestProxy {
    private String username;
    private String password;
}
