package com.intern.springsecuritydemo.repository;

import com.intern.springsecuritydemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    Optional<Student> findByUsername(String username);
}
