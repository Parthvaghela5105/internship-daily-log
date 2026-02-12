package com.intern.onetomanymapping.controller;

import com.intern.onetomanymapping.domain.Student;
import com.intern.onetomanymapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{emailId}")
    public Student getStudentByEmailId(@PathVariable String emailId)
    {
        return studentService.getStudentByEmailId(emailId);
    }

    @DeleteMapping()
    public String deleteAllStudent(){
        return studentService.deleteAllStudent();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateStudent(@PathVariable Long id , @RequestBody Student student){
        return studentService.updateStudent(id , student);
    }
}
