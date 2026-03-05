package com.intern.tailorshop.proxy;

import com.intern.tailorshop.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String username;
    private String password;
    private RoleName role;

    private Long shopId;
}
