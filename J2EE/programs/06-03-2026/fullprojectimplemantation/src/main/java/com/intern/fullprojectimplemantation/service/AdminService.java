package com.intern.fullprojectimplemantation.service;

import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;

import java.util.List;

public interface AdminService {
    List<EmployeeProxy> getAllEmployee();
    String updateEmployee(Long id , EmployeeProxy  employeeProxy);
    String deleteEmployee(Long id);
}
