package com.intern.validationdemo.repository;

import com.intern.validationdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Long> {
}
