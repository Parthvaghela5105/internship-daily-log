package com.intern.tailorshop.service;

import com.intern.tailorshop.proxy.CreateUserRequest;
import com.intern.tailorshop.proxy.LoginRequestProxy;
import com.intern.tailorshop.proxy.LoginResponseProxy;

public interface AuthService {
    String createUser(CreateUserRequest createUserRequest);
    LoginResponseProxy loginUser(LoginRequestProxy loginRequestProxy);
    String createShopAdmin(CreateUserRequest request);
}
