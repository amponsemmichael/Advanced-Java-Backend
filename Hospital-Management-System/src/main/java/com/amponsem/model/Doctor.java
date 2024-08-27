package com.amponsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Doctor extends Employee {
    private String speciality;
    @Getter
    @Setter
    @Id
    private Long id;

}
