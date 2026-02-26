package com.intern.springsecuritydemo.service.implemantation;

import com.intern.springsecuritydemo.proxy.StudentProxy;
import com.intern.springsecuritydemo.repository.StudentRepository;
import com.intern.springsecuritydemo.service.StudentService;
import com.intern.springsecuritydemo.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MapperHelper helper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        studentProxy.setPassword(passwordEncoder.encode(studentProxy.getPassword()));
        return studentRepository.save(helper.getStudent(studentProxy)).toString();
    }
}
