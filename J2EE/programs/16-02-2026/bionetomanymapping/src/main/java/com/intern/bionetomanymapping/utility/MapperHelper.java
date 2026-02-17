package com.intern.bionetomanymapping.utility;

import com.intern.bionetomanymapping.entity.Address;
import com.intern.bionetomanymapping.entity.Student;
import com.intern.bionetomanymapping.proxy.AddressProxy;
import com.intern.bionetomanymapping.proxy.StudentProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperHelper {
//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    public StudentProxy entityToProxy(Student std){
        std.getAddress().forEach(s -> s.setStudent(null));
        return modelMapper.map(std , StudentProxy.class);
    }

    public Student proxyToEntity(StudentProxy proxy){
//        return objectMapper.convertValue(proxy , Student.class);
        return modelMapper.map(proxy , Student.class);
    }

    public Address addProxyToEntity(AddressProxy proxy){
        return modelMapper.map(proxy , Address.class);
    }

    public AddressProxy addEntityToProxy(Address add){
        add.getStudent().setAddress(null);
        return modelMapper.map(add , AddressProxy.class);
    }

}
