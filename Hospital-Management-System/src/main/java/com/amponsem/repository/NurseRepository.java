package com.amponsem.repository;

import com.amponsem.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {
}
