package com.amponsem.repository;

import com.amponsem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find employees by surname
    List<Employee> findBySurname(String surname);

    // Find employees by first name
    List<Employee> findByFirstName(String firstName);

    // Find employees by surname and first name
    List<Employee> findBySurnameAndFirstName(String surname, String firstName);
}
