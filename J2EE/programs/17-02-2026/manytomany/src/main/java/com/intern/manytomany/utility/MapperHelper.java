package com.intern.manytomany.utility;

import com.intern.manytomany.domain.Address;
import com.intern.manytomany.domain.Student;
import com.intern.manytomany.proxy.AddressProxy;
import com.intern.manytomany.proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper objectMapper;

    public StudentProxy studentProxy(Student student){
        return objectMapper.convertValue(student , StudentProxy.class);
    }

    public Student student(StudentProxy studentProxy){
        return objectMapper.convertValue(studentProxy , Student.class);
    }

    public List<Student> studentList(List<StudentProxy> studentProxies){
        return studentProxies.stream().map(this::student).toList();
    }

    public List<StudentProxy> studentProxyList(List<Student> students){
        return students.stream().map(this::studentProxy).toList();
    }

    public AddressProxy entityToProxy(Address address){
        return objectMapper.convertValue(address , AddressProxy.class);
    }

    public Address proxyToEntity(AddressProxy addressProxy){
        return objectMapper.convertValue(addressProxy , Address.class);
    }

    public List<AddressProxy> listEntityToListProxy(List<Address> addresses){
        return addresses.stream().map(this::entityToProxy).toList();
    }

    public List<Address> listProxyToListEntity(List<AddressProxy> addressProxies){
        return addressProxies.stream().map(this::proxyToEntity).toList();
    }
}
