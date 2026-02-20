package com.intern.customquerymethod.repository;

import com.intern.customquerymethod.domain.Student;
import com.intern.customquerymethod.proxy.StudentProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    Optional<Student> findByEmailIdAndNumber(String emailId , String number);
}
