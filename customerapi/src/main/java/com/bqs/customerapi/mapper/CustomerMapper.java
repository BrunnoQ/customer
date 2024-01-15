package com.bqs.customerapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.bqs.customerapi.dto.CustomerDto;
import com.bqs.customerapi.entity.CustomerEntity;

@Mapper (componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDto customerEntity);

    CustomerDto toDto(CustomerEntity customerEntity);
    
}
