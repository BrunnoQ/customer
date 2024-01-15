package com.bqs.customerapi.service.impl;

import org.springframework.stereotype.Service;

import com.bqs.customerapi.dto.CustomerDto;
import com.bqs.customerapi.entity.CustomerEntity;
import com.bqs.customerapi.mapper.CustomerMapper;
import com.bqs.customerapi.repository.CustomerRepository;
import com.bqs.customerapi.service.CustomerService;

/**
 * This class implements the CustomerService interface and provides the implementation for creating a customer.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    /**
        * Creates a new customer based on the provided CustomerDto.
        *
        * @param customerDto The CustomerDto object containing the customer information.
        * @return The created CustomerDto object.
        */
    @Override
    public CustomerDto create(CustomerDto customerDto) {
        //TODO: Implement validation of fields
        CustomerEntity customerEntity = customerMapper.toEntity(customerDto);
        customerEntity = customerRepository.save(customerEntity);
        return customerMapper.toDto(customerEntity);
    }
    
}
