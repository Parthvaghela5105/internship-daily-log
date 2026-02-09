package com.example.studentsetcrud.controller;

import com.example.studentsetcrud.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    Set<Student> stdSet = new HashSet<>();

    @GetMapping(value = "/save-student/{id}/{name}/{address}/{pincode}")
    public String saveStudent(@PathVariable long id,@PathVariable(name = "name") String fullName , @PathVariable String address , @PathVariable int pincode){
        Optional<Student> optionalStudent = stdSet.stream().filter(x -> x.getId() == id).findFirst();
        if(optionalStudent.isEmpty()){
            Student s = new Student();
           s.setId(id);
           s.setName(fullName);
           s.setAddress(address);
           s.setPinCode(pincode);
           stdSet.add(s);
           return "Student has been Saved Successfully";
        }
        else{
            return "you cant create duplicate student with id "+id;
        }
    }

    @GetMapping(value="get-all-student")
    public Set<Student> getAllStudent(){
        return stdSet;
    }

    @GetMapping(value = "student/{id}")
    public Student getById(@PathVariable Integer id){
        return stdSet.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("No record found"));
    }

    @GetMapping(value = "delete-by-id")
    public String deletebyId(@RequestParam Integer id){
        boolean deletedFlag = stdSet.removeIf(x -> x.getId() == id);
        if (deletedFlag)
            return "Student has been deleted successfully";
        else
            return "Student has not been deleted";
    }

    @GetMapping(value = "update-student/{id}")
    public String updateStudent(@PathVariable Integer id ,@RequestParam String name , @RequestParam String address ,@RequestParam(required = false) Integer pincode)
    {
        Optional<Student> optionalStudent = stdSet.stream().filter(x -> x.getId() == id).findFirst();
        if(optionalStudent.isPresent())
        {
            Student s = optionalStudent.get();
            s.setName(name);
            s.setAddress(address);
            if(pincode != null)
                s.setPinCode(pincode);
            return "Student has been updated successfully";
        }else{
            return "Student is not found with id "+id;
        }
    }


}
