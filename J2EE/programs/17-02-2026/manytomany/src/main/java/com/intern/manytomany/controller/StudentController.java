package com.intern.manytomany.controller;

import com.intern.manytomany.proxy.StudentProxy;
import com.intern.manytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping()
    public String saveStudent(@RequestBody StudentProxy proxy){
        return service.saveStudent(proxy);
    }

    @GetMapping()
    public List<StudentProxy> getAllStudent(){
        return service.getAllStudent();
    }

    @GetMapping(value = "/{id}")
    public StudentProxy getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }
}
