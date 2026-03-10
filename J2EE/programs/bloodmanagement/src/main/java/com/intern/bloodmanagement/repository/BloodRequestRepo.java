package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.BloodRequest;
import com.intern.bloodmanagement.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BloodRequestRepo extends JpaRepository<BloodRequest, Long> {
    List<BloodRequest> findByHospital(Hospital hospital);
}