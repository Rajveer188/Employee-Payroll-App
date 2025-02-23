package com.capgemini_training.employeepayrollapp.repository;

import com.capgemini_training.employeepayrollapp.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

//repository for employee
@Component
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
