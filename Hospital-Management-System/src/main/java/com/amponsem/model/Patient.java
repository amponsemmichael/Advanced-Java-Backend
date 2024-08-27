package com.amponsem.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Patient {
    @Id
    private Long number;
    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;
    @ManyToOne
    private Ward ward;
    private int bedNumber;
    private String diagnosis;
    @ManyToOne
    private Doctor doctor;
}
