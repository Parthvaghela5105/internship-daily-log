package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}