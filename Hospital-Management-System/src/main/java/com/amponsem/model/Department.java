
package com.amponsem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String code;  // This must be manually assigned in the JSON payload

    private String name;
    private String building;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private List<Ward> wards;

    @OneToMany(mappedBy = "department")
    private List<Nurse> nurses;

}

