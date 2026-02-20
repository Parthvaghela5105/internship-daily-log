package com.intern.customquerymethod.service;

import com.intern.customquerymethod.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String generate_random_data();
    List<StudentProxy> getAllData();
    StudentProxy getStudentByEmailAndNumber(String emailId , String number);

}
