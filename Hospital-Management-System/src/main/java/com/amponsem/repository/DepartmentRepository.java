package com.amponsem.repository;

import com.amponsem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Optional<Department> findByCode(String code);

}
