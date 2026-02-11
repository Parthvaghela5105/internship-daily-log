package com.interns.ormdemoproject.service;

import com.interns.ormdemoproject.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeEntity employee);

    List<EmployeeEntity> getAllEmployee();

    EmployeeEntity getById(Long id);

    String updateEmployee(Long id , EmployeeEntity employee);

    String deleteEmployeeById(Long id);

    String deleteAllEmployee();
}
