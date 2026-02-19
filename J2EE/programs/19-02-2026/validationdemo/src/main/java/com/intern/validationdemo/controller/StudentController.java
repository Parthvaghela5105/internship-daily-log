package com.intern.validationdemo.controller;

import com.intern.validationdemo.proxy.StudentProxy;
import com.intern.validationdemo.service.StudentService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String saveStudent(@Valid @RequestBody StudentProxy studentProxy){
        return studentService.addStudent(studentProxy);
    }

    @GetMapping()
    public List<StudentProxy> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentProxy getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping()
    public String deleteAllStudent(){
        return studentService.deleteAllStudent();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @PostMapping(value = "/{id}")
    public String updateStudent(@RequestBody StudentProxy studentProxy , @PathVariable Long id){
        return studentService.updateStudent(studentProxy , id);
    }
}
