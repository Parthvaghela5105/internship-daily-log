package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface HospitalRepo extends JpaRepository<Hospital, Long> {
}