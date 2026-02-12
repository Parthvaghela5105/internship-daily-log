package com.intern.onetoonemapping.service;

import com.intern.onetoonemapping.domain.Student;

import java.util.List;

public interface StudentService {

    String addStudent(Student std);

    List<Student> getAllStudent();

    Student findStudentByEmailId(String emailId);

    String deleteStudent(Long id);

    String updateStudent(Long id , Student student);

    String deleteById(Long id);
}
