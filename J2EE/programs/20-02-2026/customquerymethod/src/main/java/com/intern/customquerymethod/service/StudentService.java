package com.intern.customquerymethod.service;

import com.intern.customquerymethod.proxy.StudentProxy;

import java.util.List;

public interface StudentService {
    String generate_random_data();
    List<StudentProxy> getAllData();
    StudentProxy getStudentByEmailAndNumber(String emailId , String number);
    List<StudentProxy> getStudentByEmailOrNumber(String emailId , String number);
    List<StudentProxy> getStudentByName(String name);
    List<StudentProxy> getStudentByNameIs(String name);
    List<StudentProxy> getStudentByNameEquals(String name);
    List<StudentProxy> getStudentByAgeLessThan(Integer age);
    List<StudentProxy> getStudentByAgeLessThanEqual(Integer age);
    List<StudentProxy> getStudentByAgeGreaterThan(Integer age);
    List<StudentProxy> getStudentByAgeGreaterThanEqual(Integer age);
    List<StudentProxy> getStudentByNameLike(String name);
    List<StudentProxy> getStudentByNameContaining(String name);
    List<StudentProxy> getStudentByAgeIn(List<Integer> age);
    List<StudentProxy> getStudentNameIgnoreCase(String name);
}
