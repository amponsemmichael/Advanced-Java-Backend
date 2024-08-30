package com.amponsem.controllers;

import com.amponsem.model.Department;

import com.amponsem.model.Doctor;
import com.amponsem.repository.DoctorRepository;
import com.amponsem.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable String code) {
        Optional<Department> department = departmentService.getDepartmentByCode(code);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or save a department
    @PostMapping("/save")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        if (department.getCode() == null || department.getCode().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        // Check if the referenced Doctor exists
        if (department.getDirector() != null) {
            Optional<Doctor> doctor = doctorRepository.findById(department.getDirector().getEmployeeNumber());
            if (doctor.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
        }

        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String code, @RequestBody Department departmentDetails) {
        Optional<Department> updatedDepartment = departmentService.updateDepartment(code, departmentDetails);
        return updatedDepartment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String code) {
        boolean isDeleted = departmentService.deleteDepartment(code);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
