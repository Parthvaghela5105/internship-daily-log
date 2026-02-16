package com.intern.companyworkers.repository;

import com.intern.companyworkers.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker , Long> {
}
