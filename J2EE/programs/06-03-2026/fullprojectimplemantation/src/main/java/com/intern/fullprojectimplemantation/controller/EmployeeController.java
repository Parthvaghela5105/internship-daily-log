package com.intern.fullprojectimplemantation.controller;

import com.intern.fullprojectimplemantation.proxy.AuthRequestProxy;
import com.intern.fullprojectimplemantation.proxy.AuthResponseProxy;
import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;
import com.intern.fullprojectimplemantation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeProxy employeeProxy){
        String s = employeeService.saveEmployee(employeeProxy);
        return new ResponseEntity<>(s , HttpStatus.CREATED);
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<EmployeeProxy> getByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.getByName(name) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> secure(){
        return new ResponseEntity<>("This is secure" , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseProxy> login(@RequestBody AuthRequestProxy authRequestProxy){
        return new ResponseEntity<>(employeeService.generateToken(authRequestProxy) , HttpStatus.OK);
    }
}
