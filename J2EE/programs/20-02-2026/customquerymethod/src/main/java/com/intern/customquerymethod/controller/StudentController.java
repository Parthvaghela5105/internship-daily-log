package com.intern.customquerymethod.controller;

import com.intern.customquerymethod.proxy.StudentProxy;
import com.intern.customquerymethod.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping()
    public String generateRandomData(){
        return studentService.generate_random_data();
    }

    @GetMapping("/get-all-data")
    public List<StudentProxy> getAllData(){
        return studentService.getAllData();
    }

    @GetMapping("/get-by-phone-email/{emailId}/{number}")
    public StudentProxy getStudentByEmailIdAndNumber(@PathVariable String emailId , @PathVariable String number){
        return studentService.getStudentByEmailAndNumber(emailId , number);
    }
}
