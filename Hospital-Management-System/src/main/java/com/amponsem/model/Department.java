package com.amponsem.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
    @Id
    private String code;
    private String name;
    private String building;
    @ManyToOne
    private Doctor director;

}
