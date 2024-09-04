
package com.amponsem.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "patients")
public class Patient {

    @Id
    private Long number;

    @Indexed(unique = true) // Ensure the 'number' field is unique
    private String name;

    private int age;
    private String surname;
    private String address;
    private String telephoneNumber;
    private int bedNumber;
    private String diagnosis;
}

