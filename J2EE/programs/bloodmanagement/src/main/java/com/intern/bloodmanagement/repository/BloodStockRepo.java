package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface BloodStockRepo extends JpaRepository<BloodStock, Long> {
}