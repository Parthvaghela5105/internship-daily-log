package com.example.treelayeremployee.service;

import com.example.treelayeremployee.proxy.Employee;

import java.util.List;

public interface EmployeeService {

    String saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    String removeEmployeeById(Long id);

    String updateEmployee(Long id , Employee employee);

    String removeAllEmployee();

}
