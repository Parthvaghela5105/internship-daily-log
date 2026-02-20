package com.intern.validationdemo.service.implemantation;

import com.intern.validationdemo.customized.exception.NoStudentFoundException;
import com.intern.validationdemo.entity.Student;
import com.intern.validationdemo.proxy.StudentProxy;
import com.intern.validationdemo.repository.StudentRepository;
import com.intern.validationdemo.service.StudentService;
import com.intern.validationdemo.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private MapperHelper helper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(StudentProxy studentProxy) {
        Student student = helper.student(studentProxy);
        student.getAddress().forEach(s -> s.setStudent(student));
        studentRepository.save(student);
        return "Student saved Successfully";
    }

    @Override
    public List<StudentProxy> getAllStudent() {
        return studentRepository.findAll().stream().map(s -> helper.studentProxy(s)).toList();
    }

    @Override
    public StudentProxy getStudentById(Long id) {
        Optional<Student> optStd = studentRepository.findById(id);
        if(optStd.isPresent()){
            return helper.studentProxy(optStd.get());
        }
        return null;
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> optStd = studentRepository.findById(id);
        if(optStd.isPresent()){
            studentRepository.deleteById(id);
            return "Student with id "+id+" has been deleted successfully";
        }
        return "There is no record found with id "+id;
    }

    @Override
    public String deleteAllStudent() {
        studentRepository.deleteAll();
        return "All Student has been deleted successfully";
    }

    @Override
    public String updateStudent(StudentProxy studentProxy, Long id) {
        Optional<Student> optStd = studentRepository.findById(id);
        if(optStd.isPresent()){
            studentRepository.save(helper.student(studentProxy));
            return "Student has been updated Successfully";
        }
        return "There is no record found with id "+id;
    }

    @Override
    public StudentProxy findStudentByEmail(String email) {
        Optional<Student> optStd = studentRepository.findByEmail(email);
        if(optStd.isPresent()){
            return helper.studentProxy(optStd.get());
        }else{
            throw new NoStudentFoundException("There is No Record found with email "+email , HttpStatus.NOT_FOUND.value());
        }
    }
}
