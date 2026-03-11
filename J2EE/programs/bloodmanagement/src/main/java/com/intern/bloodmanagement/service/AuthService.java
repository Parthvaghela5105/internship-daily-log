package com.intern.bloodmanagement.service;


import com.intern.bloodmanagement.proxy.AuthRequest;
import com.intern.bloodmanagement.proxy.AuthResponse;
import com.intern.bloodmanagement.proxy.ForgetPassword;
import com.intern.bloodmanagement.proxy.UserProxy;

public interface AuthService {
    String register(UserProxy proxy);
    AuthResponse login(AuthRequest request);
    String forgetPassword(ForgetPassword forgetPassword);
}
