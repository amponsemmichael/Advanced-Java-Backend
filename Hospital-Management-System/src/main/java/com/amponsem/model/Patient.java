package com.amponsem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
    @Id
    private Long number;
    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    private int bedNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
