package com.intern.globalexception.service;

import com.intern.globalexception.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentProxy studentProxy);
    List<StudentProxy> getAllStudent();
    StudentProxy getStudentByEmailId(String EmailId);
    String deleteAllStudent();
    String deleteStudentById(Long id);
    String updateStudent(StudentProxy studentProxy , Long id);
}
