package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface BloodRequestRepo extends JpaRepository<BloodRequest, Long> {
}