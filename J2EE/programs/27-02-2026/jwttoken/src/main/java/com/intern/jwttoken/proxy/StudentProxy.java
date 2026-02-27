package com.intern.jwttoken.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProxy {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String role;
}
