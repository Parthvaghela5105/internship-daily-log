package com.intern.springsecuritydemo.service;

import com.intern.springsecuritydemo.proxy.AuthReq;
import com.intern.springsecuritydemo.proxy.AuthResp;
import com.intern.springsecuritydemo.proxy.StudentProxy;

public interface StudentService {
    String saveStudent(StudentProxy studentProxy);
    AuthResp authenticateStudent(AuthReq authReq);
}
