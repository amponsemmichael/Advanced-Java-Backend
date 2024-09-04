package com.amponsem.services;

import com.amponsem.exceptions.PatientNotFoundException;
import com.amponsem.model.Patient;
import com.amponsem.repository.PatientMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientMongoRepository patientMongoRepository;

    public List<Patient> getAllPatients() {
        return patientMongoRepository.findAll();
    }

    public Patient getPatientById(Long number) {
        // Retrieve list of patients with the given number
        List<Patient> patients = patientMongoRepository.findByNumber(number);

        if (patients.isEmpty()) {
            throw new PatientNotFoundException("Patient not found with number: " + number);
        } else if (patients.size() > 1) {
            // Log a warning or handle the case where multiple patients are found
            System.err.println("Warning: Multiple patients found with number: " + number);
            // Return the first patient, or handle the situation as needed
        }

        return patients.get(0);
    }

    public Patient addPatient(Patient patient) {
        // Ensure the patient number is unique before saving
        if (patientMongoRepository.existsByNumber(patient.getNumber())) {
            throw new IllegalArgumentException("A patient with this number already exists: " + patient.getNumber());
        }
        return patientMongoRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        if (!patientMongoRepository.existsByNumber(patient.getNumber())) {
            throw new PatientNotFoundException("Patient not found with number: " + patient.getNumber());
        }
        return patientMongoRepository.save(patient);
    }

    public void deletePatient(Long number) {
        if (!patientMongoRepository.existsByNumber(number)) {
            throw new PatientNotFoundException("Patient not found with number: " + number);
        }
        patientMongoRepository.deleteByNumber(number);
    }
}
