package com.amponsem.controllers;

import com.amponsem.model.Patient;
import com.amponsem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long number) {
        Optional<Patient> patient = Optional.ofNullable(patientService.getPatientById(number));
        return patient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long number, @RequestBody Patient patient) {
        if (patientService.getPatientById(number) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        patient.setNumber(number); // Ensure the patient has the correct ID
        Patient updatedPatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long number) {
        if (patientService.getPatientById(number) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        patientService.deletePatient(number);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
