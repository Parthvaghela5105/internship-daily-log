package com.intern.manytomany.service;

import com.intern.manytomany.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentProxy studentProxy);
    List<StudentProxy> getAllStudent();
    StudentProxy getStudentById(Long id);
}
