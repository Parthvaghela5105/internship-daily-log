package com.intern.jpqlquery.controller;

import com.intern.jpqlquery.dto.StdDTO;
import com.intern.jpqlquery.proxy.StudentProxy;
import com.intern.jpqlquery.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public String addStudents(){
        return studentService.generate_random_data();
    }

    @GetMapping
    public List<StudentProxy> getAllStudent(){
        return studentService.getALlData();
    }

    @GetMapping(value = "get-students")
    public List<StdDTO> getStudents(){
        return  studentService.getStudents();
    }

    @DeleteMapping(value="/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @PostMapping(value = "/{id}/{address}")
    public String updateStudent(@PathVariable Long id , @PathVariable String address){
        return studentService.updateStudent(id , address);
    }
}
