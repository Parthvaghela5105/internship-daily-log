package com.intern.studentcourse.repository;

import com.intern.studentcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {
}
