package com.intern.fullprojectimplemantation.service;

import com.intern.fullprojectimplemantation.proxy.AuthRequestProxy;
import com.intern.fullprojectimplemantation.proxy.AuthResponseProxy;
import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;

public interface EmployeeService {
    String saveEmployee(EmployeeProxy employeeProxy);
    AuthResponseProxy generateToken(AuthRequestProxy authRequestProxy);
    EmployeeProxy getByName(String name);
}
