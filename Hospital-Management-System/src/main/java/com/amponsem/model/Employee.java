package com.amponsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Employee {
    @Id
    private Long employeeNumber;
    private String surName;
    private String firstName;
    private String address;
    private String telephoneNumber;

}

