package com.intern.onetoonemapping.controller;

import com.intern.onetoonemapping.domain.Student;
import com.intern.onetoonemapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String addStudent(@RequestBody Student std){
        return studentService.addStudent(std);
    }

    @GetMapping()
    public List<Student> findAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/search/{emailId}")
    public Student findByEmailId(@PathVariable String emailId){
        return studentService.findStudentByEmailId(emailId);
    }

    @PostMapping(value ="/{id}")
    public String updateStudent(@PathVariable Long id , @RequestBody Student student)
    {
        return studentService.updateStudent(id , student);
    }

    @DeleteMapping(value = "{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
