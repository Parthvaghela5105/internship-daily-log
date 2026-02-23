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

    @GetMapping("/email-or-number/{emailId}/{number}")
    public List<StudentProxy> getStudentByEmailIdOrNumber(@PathVariable String emailId , @PathVariable String number){
        return studentService.getStudentByEmailOrNumber(emailId , number);
    }

    @GetMapping("/get-by-name/{name}")
    public List<StudentProxy> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/get-by-nameIs/{name}")
    public List<StudentProxy> getStudentByNameIs(@PathVariable String name){
        return studentService.getStudentByNameIs(name);
    }

    @GetMapping("/get-by-nameEquals/{name}")
    public List<StudentProxy> getStudentByNameEquals(@PathVariable String name){
        return studentService.getStudentByNameEquals(name);
    }

    @GetMapping("/get-by-age-less-than/{age}")
    public List<StudentProxy> getStudentByAgeLessThan(@PathVariable Integer age){
        return studentService.getStudentByAgeLessThan(age);
    }

    @GetMapping("/get-by-age-less-than-equal/{age}")
    public List<StudentProxy> getStudentByAgeLessThanEqual(@PathVariable Integer age){
        return studentService.getStudentByAgeLessThanEqual(age);
    }

    @GetMapping("/get-by-age-greater-than/{age}")
    public List<StudentProxy> getStudentByAgeGreaterThan(@PathVariable Integer age){
        return studentService.getStudentByAgeGreaterThan(age);
    }

    @GetMapping("/get-by-age-greater-than-equal/{age}")
    public List<StudentProxy> getStudentByAgeGreaterThanEqual(@PathVariable Integer age){
        return studentService.getStudentByAgeGreaterThanEqual(age);
    }

    @GetMapping("/get-by-name-like")
    public List<StudentProxy> getStudentNameLike(@RequestParam String name){
        return studentService.getStudentByNameLike(name);
    }

    @GetMapping("/get-by-name-containing/{name}")
    public List<StudentProxy> getStudentNameContaining(@PathVariable String name){
        return studentService.getStudentByNameContaining(name);
    }


    @GetMapping("/get-by-age-in")
    public List<StudentProxy> getStudentByAgeIn(@RequestParam List<Integer> age){
        return studentService.getStudentByAgeIn(age);
    }

    @GetMapping("/get-name-ingorecase/{name}")
    public List<StudentProxy> getStudentNameIgnoreCase(@PathVariable String name){
        return studentService.getStudentNameIgnoreCase(name);
    }
}
