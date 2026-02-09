package com.example.studentprogram.controller;

import com.example.studentprogram.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="student-data")
public class StudentController {
    List<Student> list;

    @GetMapping("/save-all")
    public String saveAllStudent(){
        list = new ArrayList<>();
        list.add(new Student("Parth","101","Ahmedabad",382311,"Success"));
        list.add(new Student("Ayush","102","Nikol",382211,"Success"));
        list.add(new Student("Jenil","103","Surat",382311,"Success"));
        list.add(new Student("Yogansh","104","Baroda",382311,"Success"));
        list.add(new Student("Aditya","105","Mahesana",382311,"Success"));
        list.add(new Student("Kevin","106","Anand",382311,"Success"));
        list.add(new Student("Dinesh","107","Nadiyad",382311,"Success"));
        list.add(new Student("Deepak","108","Rajkot",382311,"Success"));
        list.add(new Student("Jay","109","Bhavnagar",382311,"Success"));
        list.add(new Student("Vinay","111","Junagadg",382311,"Success"));

        return "Saved All data Successfully";
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudent(){
        if(list == null)
            return null;

        return list;
    }

    @GetMapping(value = "/get-by-id")
    public Student getWithId(){
        String id = "110";
        Student s = list.stream().filter(x -> x.getRollno().equals(id))
                .findFirst().orElse(new Student("","","",0,"No Record found"));
        return s;
    }

    @GetMapping(value="/remove-by-id")
    public String removeById(){
        String id = "101";
        Student s = list.stream().filter(x -> x.getRollno().equals(id))
                .findFirst().orElse(null);
        if(s == null)
            return "Data is not available";

        list.remove(s);
        return "Deleted Successfully";
    }

    @GetMapping(value = "/remove-all")
    public String removeAll(){
        if(list.isEmpty())
            return "No data available";
        list.clear();
        return "Delete all data successfully";
    }

}
