package com.intern.globalexception.controller;

import com.intern.globalexception.proxy.StudentProxy;
import com.intern.globalexception.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody StudentProxy studentProxy){
        String s = studentService.saveStudent(studentProxy);
        return new ResponseEntity<>(s , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentProxy>> getAllStudent(){
        List<StudentProxy> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent , HttpStatus.OK);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<StudentProxy> getStudentByEmailId(@PathVariable String emailId){
        StudentProxy studentByEmailId = studentService.getStudentByEmailId(emailId);
        return new ResponseEntity<>(studentByEmailId , HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllStudent(){
        return new ResponseEntity<>(studentService.deleteAllStudent() , HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.deleteStudentById(id) , HttpStatus.NO_CONTENT);
    }

    @PostMapping(value ="/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id , @RequestBody StudentProxy studentProxy){
        return new ResponseEntity<>(studentService.updateStudent(studentProxy , id) , HttpStatus.OK);
    }

}
