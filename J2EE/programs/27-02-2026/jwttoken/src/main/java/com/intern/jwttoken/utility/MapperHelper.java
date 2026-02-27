package com.intern.jwttoken.utility;

import com.intern.jwttoken.domain.Student;
import com.intern.jwttoken.proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public Student getStudent(StudentProxy studentProxy){
        return mapper.convertValue(studentProxy , Student.class);
    }

    public StudentProxy getStudentProxy(Student student){
        return mapper.convertValue(student , StudentProxy.class);
    }
}
