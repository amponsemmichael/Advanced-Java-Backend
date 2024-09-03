package com.amponsem.services;

import com.amponsem.model.Nurse;
import com.amponsem.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Optional<Nurse> getNurseById(Long id) {
        return nurseRepository.findById(Math.toIntExact(id));
    }

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Optional<Nurse> updateNurse(Long id, Nurse nurseDetails) {
        return nurseRepository.findById(Math.toIntExact(id)).map(nurse -> {
            nurse.setSurname(nurseDetails.getSurname());
            nurse.setFirstName(nurseDetails.getFirstName());
            nurse.setAddress(nurseDetails.getAddress());
            nurse.setTelephoneNumber(nurseDetails.getTelephoneNumber());
            nurse.setRotation(nurseDetails.getRotation());
            nurse.setSalary(nurseDetails.getSalary());
            nurse.setDepartment(nurseDetails.getDepartment());
            nurse.setWards(nurseDetails.getWards());
            return nurseRepository.save(nurse);
        });
    }

    public boolean deleteNurse(Long id) {
        if (nurseRepository.existsById(Math.toIntExact(id))) {
            nurseRepository.deleteById(Math.toIntExact(id));
            return true;
        } else {
            return false;
        }
    }
}
