package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.DonorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DonorDetailsRepo extends JpaRepository<DonorDetails, Long> {
}