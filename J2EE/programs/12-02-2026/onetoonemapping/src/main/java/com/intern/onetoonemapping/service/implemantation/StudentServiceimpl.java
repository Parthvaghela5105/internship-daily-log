package com.intern.onetoonemapping.service.implemantation;

import com.intern.onetoonemapping.domain.PersonalInformation;
import com.intern.onetoonemapping.domain.Student;
import com.intern.onetoonemapping.repository.StudentRepository;
import com.intern.onetoonemapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepository stdRepository;

    @Override
    public String addStudent(Student std) {
        PersonalInformation pr = std.getPersonalInformation();

        return stdRepository.save(std).toString();
    }

    @Override
    public List<Student> getAllStudent() {
        return stdRepository.findAll();
    }

    @Override
    public Student findStudentByEmailId(String emailId) {
        return stdRepository.findByEmailId(emailId).orElse(null);
    }

    @Override
    public String deleteStudent(Long id) {
        Optional<Student> optStudent = stdRepository.findById(id);
        if(optStudent.isPresent())
        {
            Student std = optStudent.get();
            stdRepository.delete(std);
            return "Student has been deleted successfully";
        }
        return "Student is not deleted";
    }

    @Override
    public String updateStudent(Long id, Student student) {
        Optional<Student> optStudent = stdRepository.findById(id);
        if (optStudent.isPresent()) {
            Student student1 = optStudent.get();
            PersonalInformation pr = student1.getPersonalInformation();
            Long previousId = student1.getPersonalInformation().getId();

            student.setId(id);
            student.getPersonalInformation().setId(previousId);

            stdRepository.save(student);
            return student.toString();
        }
        return "no record available with  id " + id;
    }

    @Override
    public String deleteById(Long id) {
        stdRepository.deleteById(id);
        return "deleted successfully";
    }
}
