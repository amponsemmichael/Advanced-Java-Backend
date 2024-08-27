package com.amponsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Doctor extends Employee {

    private String speciality;

    @OneToOne(mappedBy = "director")
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    // Getters and setters
}
