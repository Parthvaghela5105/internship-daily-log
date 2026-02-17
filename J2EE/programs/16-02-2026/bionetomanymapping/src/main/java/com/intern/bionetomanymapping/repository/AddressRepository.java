package com.intern.bionetomanymapping.repository;

import com.intern.bionetomanymapping.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long> {
    List<Address> findByCity(String city);
}
