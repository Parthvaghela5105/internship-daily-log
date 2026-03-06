package com.intern.fullprojectimplemantation.util;

import com.intern.fullprojectimplemantation.domain.Employee;
import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public Employee employee(EmployeeProxy employeeProxy){
        return mapper.convertValue(employeeProxy , Employee.class);
    }

    public EmployeeProxy employeeProxy(Employee employee){
        return mapper.convertValue(employee , EmployeeProxy.class);
    }
}
