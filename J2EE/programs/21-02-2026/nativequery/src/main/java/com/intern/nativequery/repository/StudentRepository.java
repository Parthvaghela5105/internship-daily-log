package com.intern.nativequery.repository;

import com.intern.nativequery.domain.Student;
import com.intern.nativequery.projection.StudentNameEmailProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    @Query(value = "SELECT * FROM student",nativeQuery = true)
    List<Student> getAllStudent();

    @Query(value = "SELECT name,address FROM student WHERE id=:id",nativeQuery = true)
    Object[] getStudentById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student where id=:id",nativeQuery = true)
    void deleteStudentById(@Param("id") Long id);

    @Query(value = "SELECT s.name , s.email_id FROM student s",nativeQuery = true)
    List<StudentNameEmailProjection> getNameEmailId();

    @Transactional
    @Modifying
    @Query(value = "UPDATE student set address=:address where id=:id",nativeQuery = true)
    void updateStudent(@Param("id") Long id , @Param("address") String address);
}
