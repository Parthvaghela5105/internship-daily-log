package com.intern.onetoonebidirectional.controller;

import com.intern.onetoonebidirectional.dto.StudentDTO;
import com.intern.onetoonebidirectional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService stdService;

    @PostMapping()
    public String saveStudent(@RequestBody StudentDTO studentDTO){
        return stdService.saveStudent(studentDTO);
    }

    @GetMapping()
    public List<StudentDTO> getAllStudent(){
        return stdService.getAllStudent();
    }

    @GetMapping(value = "/{emailId}")
    public StudentDTO getStudentByEmailId(@PathVariable String emailId){
        return stdService.getStudentByEmailId(emailId);
    }

}
