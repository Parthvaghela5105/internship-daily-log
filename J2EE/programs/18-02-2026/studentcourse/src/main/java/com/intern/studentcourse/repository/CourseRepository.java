package com.intern.studentcourse.repository;

import com.intern.studentcourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {
}
