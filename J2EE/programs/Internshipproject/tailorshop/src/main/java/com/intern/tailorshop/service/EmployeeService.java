package com.intern.tailorshop.service;

import com.intern.tailorshop.proxy.EmployeeProxy;

import java.util.List;

public interface EmployeeService {

    String addEmployee(EmployeeProxy proxy);

    List<EmployeeProxy> getAllEmployee(Long shopId);

    String updateEmployee(Long id , EmployeeProxy proxy);

    void deactivateEmployee(Long id);

}
