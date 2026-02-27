package com.intern.jwttoken.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseProxy {
    private String jwt;
    private Long userId;
}
