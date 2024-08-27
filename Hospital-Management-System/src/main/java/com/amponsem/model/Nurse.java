package com.amponsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class Nurse extends Employee {
    private String rotation;
    private BigDecimal salary;
    @Getter
    @Setter
    @Id
    private Long id;

}
