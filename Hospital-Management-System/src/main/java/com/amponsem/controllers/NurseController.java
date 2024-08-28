package com.amponsem.controllers;

import com.amponsem.model.Nurse;
import com.amponsem.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NurseController {

    @Autowired
    private NurseRepository nurseRepository;

    // Create a new nurse
    @PostMapping("/save")
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
        Nurse savedNurse = nurseRepository.save(nurse);
        return ResponseEntity.ok(savedNurse);
    }

    // Get all nurses
    @GetMapping("/all")
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseRepository.findAll();
        return ResponseEntity.ok(nurses);
    }

    // Get a nurse by ID
    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        Optional<Nurse> nurse = nurseRepository.findById(Math.toIntExact(id));
        return nurse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a nurse
    @PutMapping("/update/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails) {
        Optional<Nurse> optionalNurse = nurseRepository.findById(Math.toIntExact(id));
        if (optionalNurse.isPresent()) {
            Nurse nurse = getNurse(nurseDetails, optionalNurse);

            Nurse updatedNurse = nurseRepository.save(nurse);
            return ResponseEntity.ok(updatedNurse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private static Nurse getNurse(Nurse nurseDetails, Optional<Nurse> optionalNurse) {
        Nurse nurse = optionalNurse.get();
        nurse.setSurname(nurseDetails.getSurname());
        nurse.setFirstName(nurseDetails.getFirstName());
        nurse.setAddress(nurseDetails.getAddress());
        nurse.setTelephoneNumber(nurseDetails.getTelephoneNumber());
        nurse.setRotation(nurseDetails.getRotation());
        nurse.setSalary(nurseDetails.getSalary());
        nurse.setDepartment(nurseDetails.getDepartment());
        nurse.setWards(nurseDetails.getWards());
        return nurse;
    }

    // Delete a nurse by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable Long id) {
        if (nurseRepository.existsById(Math.toIntExact(id))) {
            nurseRepository.deleteById(Math.toIntExact(id));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



