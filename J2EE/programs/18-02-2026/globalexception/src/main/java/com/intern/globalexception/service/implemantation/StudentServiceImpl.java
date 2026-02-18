package com.intern.globalexception.service.implemantation;

import com.intern.globalexception.customized.exception.NoStudentFoundException;
import com.intern.globalexception.entity.Student;
import com.intern.globalexception.proxy.StudentProxy;
import com.intern.globalexception.repository.StudentRepository;
import com.intern.globalexception.service.StudentService;
import com.intern.globalexception.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        Student student = helper.proxyToEntity(studentProxy);
        student.getAddress().forEach(a -> a.setStudent(student));
        repository.save(student);
        return "Saved Successfully";
    }

    @Override
    public List<StudentProxy> getAllStudent() {
        return repository.findAll().stream().map(s -> helper.entityTOProxy(s)).toList();
    }

    @Override
    public StudentProxy getStudentByEmailId(String emailId) {
        Optional<Student> email=repository.findByEmailId(emailId);

        if(email.isPresent()){
            return helper.entityTOProxy(email.get());
        }else throw new NoStudentFoundException("Student not found with give emailid "+emailId , HttpStatus.NOT_FOUND.value());

    }

    @Override
    public String deleteAllStudent() {
        repository.deleteAll();;
        return "Deleted All Student Successfully";
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> optStd = repository.findById(id);
        if(optStd.isPresent()){
            repository.deleteById(id);
            return "Deleted student Successfully";
        }else{
            throw new NoStudentFoundException("There is no record avilable with id "+id , HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String updateStudent(StudentProxy studentProxy, Long id) {
        Optional<Student> optStd = repository.findById(id);
        if(optStd.isPresent()){
            Student student = helper.proxyToEntity(studentProxy);
            student.getAddress().forEach(a -> a.setStudent(student));
            repository.save(student);
            return "Student updated Successfully";
        }else{
            throw new NoStudentFoundException("There is no record avilable with id "+id , HttpStatus.NOT_FOUND.value());
        }
    }
}
