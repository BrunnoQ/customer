package com.bqs.customerapi.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record CustomerDto(Long id, String firstName, String lastName, LocalDate birthDate, String cpf) {

}