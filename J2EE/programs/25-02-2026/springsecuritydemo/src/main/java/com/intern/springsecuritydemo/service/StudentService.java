package com.intern.springsecuritydemo.service;

import com.intern.springsecuritydemo.proxy.StudentProxy;

public interface StudentService {
    String saveStudent(StudentProxy studentProxy);
}
