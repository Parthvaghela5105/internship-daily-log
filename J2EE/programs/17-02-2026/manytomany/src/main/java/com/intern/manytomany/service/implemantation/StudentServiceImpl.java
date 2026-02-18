package com.intern.manytomany.service.implemantation;

import com.intern.manytomany.proxy.StudentProxy;
import com.intern.manytomany.repository.StudentRepository;
import com.intern.manytomany.service.StudentService;
import com.intern.manytomany.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MapperHelper helper;

    @Autowired
    private StudentRepository repository;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        return repository.save(helper.student(studentProxy)).toString();
    }

    @Override
    public List<StudentProxy> getAllStudent() {
        return helper.studentProxyList(repository.findAll());
    }

    @Override
    public StudentProxy getStudentById(Long id) {
        return helper.studentProxy(repository.findById(id).orElse(null));
    }
}
