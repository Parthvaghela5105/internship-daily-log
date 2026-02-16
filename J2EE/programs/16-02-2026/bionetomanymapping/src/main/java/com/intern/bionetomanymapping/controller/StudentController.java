package com.intern.bionetomanymapping.controller;

import com.intern.bionetomanymapping.entity.Student;
import com.intern.bionetomanymapping.proxy.StudentProxy;
import com.intern.bionetomanymapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping()
    public String saveStudent(@RequestBody StudentProxy studentProxy){
        return studentService.saveStudent(studentProxy);
    }

    @GetMapping()
    public List<StudentProxy> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentProxy getStudentById(Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping()
    public String deleteAllStudent(){
        return studentService.deleteAllStudent();
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateStudentById(@RequestBody StudentProxy studentProxy , @PathVariable Long id){
        return studentService.updateStudent(id , studentProxy);
    }
}
