package com.intern.bloodmanagement.proxy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProxy {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String status;
}
