package com.amponsem.repository;

import com.amponsem.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientMongoRepository extends MongoRepository<Patient, Long> {
    List<Patient> findByNumber(Long number);  // Changed return type to List<Patient>
    boolean existsByNumber(Long number);
    void deleteByNumber(Long number);
}
