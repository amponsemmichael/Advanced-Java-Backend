package com.amponsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity

public class Nurse extends Employee {
    private String rotation;
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_code")
    private Department department;

    @OneToMany(mappedBy = "supervisor")
    private List<Ward> wards;
}

