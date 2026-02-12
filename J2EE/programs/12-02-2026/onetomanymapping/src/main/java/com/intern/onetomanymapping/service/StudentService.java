package com.intern.onetomanymapping.service;

import com.intern.onetomanymapping.domain.Student;

import java.util.List;

public interface StudentService {

    String saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentByEmailId(String email);

    String deleteStudentById(Long id);

    String deleteAllStudent();

    String updateStudent(Long id , Student student);
}
