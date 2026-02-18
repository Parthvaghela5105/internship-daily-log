package com.intern.globalexception.repository;

import com.intern.globalexception.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmailId(String emailId);
}
