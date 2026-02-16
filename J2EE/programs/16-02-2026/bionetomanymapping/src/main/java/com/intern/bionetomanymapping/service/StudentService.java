package com.intern.bionetomanymapping.service;

import com.intern.bionetomanymapping.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentProxy studentProxy);
    List<StudentProxy> getAllStudents();
    StudentProxy getStudentById(Long id);
    String deleteAllStudent();
    String deleteStudentById(Long id);
    String updateStudent(Long id , StudentProxy studentProxy);
}
