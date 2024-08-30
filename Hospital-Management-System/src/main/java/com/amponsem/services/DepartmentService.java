package com.amponsem.services;

import com.amponsem.model.Department;
import com.amponsem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PlatformTransactionManager transactionManager; // For programmatic transactions

    public Department saveDepartment(Department department) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("SaveDepartmentTransaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Department savedDepartment = departmentRepository.save(department);
            transactionManager.commit(status);
            return savedDepartment;
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentByCode(String code) {
        return departmentRepository.findById(code);
    }

    public Optional<Department> updateDepartment(String code, Department departmentDetails) {
        return departmentRepository.findById(code).map(existingDepartment -> {
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setName("UpdateDepartmentTransaction");
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                existingDepartment.setName(departmentDetails.getName());
                existingDepartment.setBuilding(departmentDetails.getBuilding());
                existingDepartment.setDirector(departmentDetails.getDirector());
                existingDepartment.setWards(departmentDetails.getWards());
                existingDepartment.setNurses(departmentDetails.getNurses());
                departmentRepository.save(existingDepartment);
                transactionManager.commit(status);
                return existingDepartment;
            } catch (Exception e) {
                transactionManager.rollback(status);
                throw e;
            }
        });
    }

    public boolean deleteDepartment(String code) {
        if (departmentRepository.existsById(code)) {
            departmentRepository.deleteById(code);
        }
        return false;
    }
}
