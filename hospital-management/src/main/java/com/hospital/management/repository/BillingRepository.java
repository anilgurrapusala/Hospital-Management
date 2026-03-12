package com.hospital.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.management.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long>{

	
	@Query(value = "select * from billing where consultation_fee between 100 and 900",nativeQuery = true)
	List<Billing> findConsutanceFee();

}
