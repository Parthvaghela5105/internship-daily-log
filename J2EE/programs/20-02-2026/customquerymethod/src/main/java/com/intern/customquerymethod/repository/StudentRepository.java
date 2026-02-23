package com.intern.customquerymethod.repository;

import com.intern.customquerymethod.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    Optional<Student> findByEmailIdAndNumber(String emailId , String number);
    List<Student> findByEmailIdOrNumber(String emailId, String number);
    List<Student> findByName(String name);
    List<Student> findByNameIs(String name);
    List<Student> findByNameEquals(String name);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByAgeLessThanEqual(Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeGreaterThanEqual(Integer age);
    List<Student> findByNameLike(String name);
    List<Student> findByNameContaining(String name);
    List<Student> findByAgeIn(List<Integer> age);
    List<Student> findByNameIgnoreCase(String name);

}
