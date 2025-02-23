package com.capgemini_training.employeepayrollapp.service;

import com.capgemini_training.employeepayrollapp.model.EmployeeEntity;
import com.capgemini_training.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //method to add employee
    public EmployeeEntity addEmployee(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }
    //method to get employee by id
    public EmployeeEntity getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }
    //method to update employee
    public EmployeeEntity udpdateEmployee(int id, EmployeeEntity employee){
        //get employee
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        //check if null
        if(employeeEntity != null){
            employeeEntity.setName(employee.getName());
            employeeEntity.setSalary(employee.getSalary());
            return employeeRepository.save(employeeEntity);
        }
        return null;
    }
    //method to delete employee
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
    //method to show all employee
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
