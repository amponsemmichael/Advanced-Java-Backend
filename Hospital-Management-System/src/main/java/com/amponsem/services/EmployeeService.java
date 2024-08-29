package com.amponsem.services;

import com.amponsem.model.Employee;
import com.amponsem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or update an employee
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read an employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findBySurname(String surname) {
        return employeeRepository.findBySurname(surname);
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<Employee> findBySurNameAndFirstName(String surname, String firstName) {
        return employeeRepository.findBySurnameAndFirstName(surname, firstName);
    }
}

