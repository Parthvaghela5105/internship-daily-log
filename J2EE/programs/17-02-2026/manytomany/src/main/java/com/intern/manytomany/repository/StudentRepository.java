package com.intern.manytomany.repository;

import com.intern.manytomany.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {
}
