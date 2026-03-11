package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long>{

}
