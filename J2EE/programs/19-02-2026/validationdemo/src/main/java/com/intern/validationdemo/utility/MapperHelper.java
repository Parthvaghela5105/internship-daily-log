package com.intern.validationdemo.utility;

import com.intern.validationdemo.entity.Address;
import com.intern.validationdemo.entity.Student;
import com.intern.validationdemo.proxy.AddressProxy;
import com.intern.validationdemo.proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public Student student(StudentProxy studentProxy){
        return mapper.convertValue(studentProxy, Student.class);
    }

    public StudentProxy studentProxy(Student student){
        student.getAddress().forEach(s -> s.setStudent(null));
        return mapper.convertValue(student , StudentProxy.class);
    }

    public Address address(AddressProxy addressProxy){
        return mapper.convertValue(addressProxy , Address.class);
    }

    public AddressProxy addressProxy(Address address){
        address.getStudent().setAddress(null);
        return mapper.convertValue(address , AddressProxy.class);
    }

}
