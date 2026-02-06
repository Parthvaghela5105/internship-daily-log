package com.example.studentprogram.controller;

import com.example.studentprogram.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {
    Student s = null;

    @GetMapping(value ="/save-student")
    public String saveStudent(){
        s = new Student();
        s.setName("parth");
        s.setPincode(382350);
        s.setRollno("101");
        s.setAddress("Ahmedabad");
        s.setStatusMessage("Success");

        return "Saved Successfully";
    }

    @GetMapping(value = "/get-student")
    public Student getStudent(){
        if(s==null)
            s = new Student();
        s.setStatusMessage("No record found");
        return s;
    }

}
