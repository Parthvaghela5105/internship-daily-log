package com.intern.bloodmanagement.repository;

import com.intern.bloodmanagement.domain.DonorDetails;
import com.intern.bloodmanagement.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DonorDetailsRepo extends JpaRepository<DonorDetails, Long> {

    Optional<DonorDetails> findByUsers(Users users);

    Optional<List<DonorDetails>> findByBloodGroup(String bloodGroup);

}