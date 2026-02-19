package com.intern.validationdemo.service;

import com.intern.validationdemo.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String addStudent(StudentProxy studentProxy);
    List<StudentProxy> getAllStudent();
    StudentProxy getStudentById(Long id);
    String deleteStudentById(Long id);
    String deleteAllStudent();
    String updateStudent(StudentProxy studentProxy , Long id);
}
