package com.intern.tailorshop.proxy;

import lombok.Data;

@Data
public class LoginResponseProxy {
    private String token;
    private String username;
    private String role;
}
