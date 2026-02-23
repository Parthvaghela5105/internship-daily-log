package com.intern.jpqlquery.service;

import com.intern.jpqlquery.dto.StdDTO;
import com.intern.jpqlquery.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String generate_random_data();
    List<StudentProxy> getALlData();
    List<StdDTO> getStudents();
    String deleteStudentById(Long id);
    String updateStudent(Long id , String address);
}
