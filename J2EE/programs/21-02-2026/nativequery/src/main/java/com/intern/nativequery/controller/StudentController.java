package com.intern.nativequery.controller;

import com.intern.nativequery.projection.StudentNameEmailProjection;
import com.intern.nativequery.proxy.StudentProxy;
import com.intern.nativequery.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String generateRandomData(){
        return studentService.generate_random_data();
    }

//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable Long id){
//
//    }

    @GetMapping()
    public List<StudentProxy> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/{id}")
    public Object[] getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping(value = "name-email")
    public List<StudentNameEmailProjection> getNameEmailId(){
        return studentService.getStudentNameEmailId();
    }

    @PostMapping(value="update-student/{id}/{address}")
    public String updateStudent(@PathVariable Long id,@PathVariable String address){
        return studentService.updateStudent(id , address);
    }
}
