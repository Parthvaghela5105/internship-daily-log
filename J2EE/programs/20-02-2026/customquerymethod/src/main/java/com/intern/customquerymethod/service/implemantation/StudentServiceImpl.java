package com.intern.customquerymethod.service.implemantation;

import com.github.javafaker.Faker;
import com.intern.customquerymethod.domain.Student;
import com.intern.customquerymethod.proxy.StudentProxy;
import com.intern.customquerymethod.repository.StudentRepository;
import com.intern.customquerymethod.service.StudentService;
import com.intern.customquerymethod.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Faker faker;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String generate_random_data() {
        for(int i = 1;i <= 100; i++)
        {
            Student s = new Student();
            s.setName(faker.name().name());
            s.setAddress(faker.address().fullAddress());
            s.setAge(faker.number().numberBetween(10 , 20));
            s.setNumber(faker.phoneNumber().phoneNumber());
            s.setEmailId(faker.internet().emailAddress());
            studentRepository.save(s);
        }
        return "Saved All data successfully";
    }

    @Override
    public List<StudentProxy> getAllData() {
        return studentRepository.findAll().stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public StudentProxy getStudentByEmailAndNumber(String emailId, String number) {
        Optional<Student> optStd = studentRepository.findByEmailIdAndNumber(emailId, number);
        if(optStd.isPresent()){
            Student student = optStd.get();
            return helper.getStudentProxy(student);
        }
        return null;
    }
}
