package com.amponsem.controllers;

import com.amponsem.model.Department;
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

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable String code) {
        Optional<Department> department = departmentService.getDepartmentByCode(code);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
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
