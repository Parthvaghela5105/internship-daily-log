package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.Donation;
import com.intern.bloodmanagement.domain.DonorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DonationRepo extends JpaRepository<Donation, Long> {

    Optional<List<Donation>> findByDonorDetails(DonorDetails donorDetails);

}