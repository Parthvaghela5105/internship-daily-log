package com.intern.bionetomanymapping.utility;

import com.intern.bionetomanymapping.entity.Student;
import com.intern.bionetomanymapping.proxy.StudentProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class MapperHelper {
//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    public StudentProxy entityToProxy(Student std){
        std.getAddress().forEach(s -> s.setStudent(null));
//        return objectMapper.convertValue(std , StudentProxy.class);
        return modelMapper.map(std , StudentProxy.class);
    }

    public Student proxyToEntity(StudentProxy proxy){
//        return objectMapper.convertValue(proxy , Student.class);
        return modelMapper.map(proxy , Student.class);
    }

    public List<StudentProxy> listEntityToListProxy(List<Student> students){
        return students.stream().map(s -> modelMapper.map(s , StudentProxy.class)).toList();
    }

    public List<Student> listProxyToListEntity(List<StudentProxy> studentProxies){
        return studentProxies.stream().map(s -> modelMapper.map(s , Student.class)).toList();
    }
}
