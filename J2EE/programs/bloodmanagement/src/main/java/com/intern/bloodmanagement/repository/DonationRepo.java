package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DonationRepo extends JpaRepository<Donation, Long> {
}