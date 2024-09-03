package com.amponsem.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Ward {
    @Id
    private Long number;
    private int numberOfBeds;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @ManyToOne
    @JoinColumn(name = "department_code")
    private Department department;

    @OneToMany(mappedBy = "ward")
    private List<Patient> patients;

}
