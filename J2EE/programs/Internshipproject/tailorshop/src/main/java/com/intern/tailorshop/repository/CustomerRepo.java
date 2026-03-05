package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}