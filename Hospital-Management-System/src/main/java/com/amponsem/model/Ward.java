package com.amponsem.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ward {
    @Id
    private Long number;
    private int numberOfBeds;
    @ManyToOne
    private Nurse supervisor;
    @ManyToOne
    private Department department;

}
