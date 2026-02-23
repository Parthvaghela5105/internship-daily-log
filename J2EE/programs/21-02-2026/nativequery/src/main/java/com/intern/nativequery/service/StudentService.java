package com.intern.nativequery.service;

import com.intern.nativequery.projection.StudentNameEmailProjection;
import com.intern.nativequery.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String generate_random_data();
    Object[] getStudentById(Long id);
    String deleteStudentById(Long id);
    List<StudentProxy> getAllStudent();
    List<StudentNameEmailProjection> getStudentNameEmailId();
    String updateStudent(Long id , String address);
}
