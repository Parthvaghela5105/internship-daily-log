package com.intern.globalexception.repository;

import com.intern.globalexception.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long> {

}
