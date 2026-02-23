package com.intern.jpqlquery.repository;

import com.intern.jpqlquery.domain.Student;
import com.intern.jpqlquery.dto.StdDTO;
import jakarta.transaction.Transactional;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    @Query(value = "SELECT s FROM Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT new com.intern.jpqlquery.dto.StdDTO(s.name , s.address) FROM Student s")
    List<StdDTO> getStudents();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Student s WHERE s.id=:id")
    void deleteStudentByID(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Student s SET s.address=:address WHERE s.id=:id")
    void updateStudent(@Param("id") Long id ,@Param("address") String address);
}
