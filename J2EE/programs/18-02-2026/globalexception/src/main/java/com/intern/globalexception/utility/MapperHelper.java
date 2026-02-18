package com.intern.globalexception.utility;

import com.intern.globalexception.entity.Address;
import com.intern.globalexception.entity.Student;
import com.intern.globalexception.proxy.AddressProxy;
import com.intern.globalexception.proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public Student proxyToEntity(StudentProxy studentProxy){
        return mapper.convertValue(studentProxy, Student.class);
    }

    public StudentProxy entityTOProxy(Student student){
        student.getAddress().forEach(a -> a.setStudent(null));
        return mapper.convertValue(student , StudentProxy.class);
    }

    public Address addProxyToEntity(AddressProxy addressProxy){
        return mapper.convertValue(addressProxy , Address.class);
    }

    public AddressProxy addressProxy(Address address){
        return mapper.convertValue(address , AddressProxy.class);
    }
}
