package com.intern.tailorshop.controller;

import com.intern.tailorshop.proxy.EmployeeProxy;
import com.intern.tailorshop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/employee")
@PreAuthorize("hasRole('SHOP_ADMIN')")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeProxy proxy){
        String s = employeeService.addEmployee(proxy);
        return new ResponseEntity<>(s , HttpStatus.CREATED);
    }

}
