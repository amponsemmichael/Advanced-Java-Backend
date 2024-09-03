package com.amponsem.services;

import com.amponsem.model.Department;
import com.amponsem.model.Doctor;
import com.amponsem.model.Ward;
import com.amponsem.repository.DepartmentRepository;
import com.amponsem.repository.DoctorRepository;
import com.amponsem.repository.WardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private WardRepository wardRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Cacheable(value = "department", key="#code")
    public Optional<Department> getDepartmentByCode(String code) {
        System.out.println("loading from database");
        return departmentRepository.findByCode(code);
    }

    public Department createDepartment(Department department) {
        Doctor director = department.getDirector();
        if (director != null) {
            doctorRepository.save(director);
        }
        return departmentRepository.save(department);
    }

    @CachePut(value = "departments", key = "#code")
    public Optional<Department> updateDepartment(String code, Department departmentDetails) {
        return departmentRepository.findById(code).map(department -> {
            department.setName(departmentDetails.getName());
            department.setBuilding(departmentDetails.getBuilding());
            department.setDirector(departmentDetails.getDirector());
            department.setWards(departmentDetails.getWards());
            department.setNurses(departmentDetails.getNurses());
            return departmentRepository.save(department);
        });
    }

    @CacheEvict(value = "departments", key = "#code")
    @Transactional
    public boolean deleteDepartment(String code) {
        Department department = departmentRepository.findById(code).orElse(null);
        if (department != null) {
            List<Ward> departmentWards = department.getWards();
            if (departmentWards != null) {
                for (Ward ward : departmentWards) {
                    wardRepository.deleteById(ward.getNumber());
                }
            }
        }

        return departmentRepository.findByCode(code)
                .map(dpt -> {
                    departmentRepository.delete(dpt);
                    return true;
                })
                .orElse(false);
    }
}
