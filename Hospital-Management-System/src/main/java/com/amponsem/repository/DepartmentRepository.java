package com.amponsem.repository;

import com.amponsem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Find department by code
    @Query("SELECT d FROM Department d WHERE d.code = :code")
    Optional<Department> findByCode(@Param("code") String code);

    // Find all departments
    @Query("SELECT d FROM Department d")
    List<Department> findAllDepartments();

    // Custom query to find departments by name
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> findDepartmentsByName(@Param("name") String name);

    // Custom query to count departments
    @Query("SELECT COUNT(d) FROM Department d")
    long countDepartments();
}
