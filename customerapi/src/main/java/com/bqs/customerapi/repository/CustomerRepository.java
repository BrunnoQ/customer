package com.bqs.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bqs.customerapi.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
}
