package com.capgemini_training.employeepayrollapp.service;

import com.capgemini_training.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini_training.employeepayrollapp.model.EmployeeEntity;
import com.capgemini_training.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //method to add employee
    public EmployeeDTO addEmployee(EmployeeEntity employee){
        EmployeeEntity employeeEntity = employeeRepository.save(employee);
        //convert entity to dto and return
        return new EmployeeDTO(employeeEntity);
    }
    //method to get employee by id
    public EmployeeDTO getEmployeeById(int id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //convert entity to dto and return
        if(employeeEntity == null){
            return null;
        }
        return new EmployeeDTO(employeeEntity);
    }
    //method to update employee
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        //get existing employee
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException ("Employee not found with id: " + id));

        // Update fields only if new values are provided
        if (employeeDTO.getName() != null) {
            employeeEntity.setName(employeeDTO.getName());
        }
        if (employeeDTO.getSalary() > 0) {
            employeeEntity.setSalary(employeeDTO.getSalary());
        }

        //save the updated entity
        EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);

        //convert entity to DTO and return
        return new EmployeeDTO(updatedEmployee);
    }
    //method to delete employee
    public void deleteEmployee(int id){
        if (!employeeRepository.existsById(id)) {
            throw new NoSuchElementException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
    //method to show all employee
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();

        for (EmployeeEntity employee : employees) {
            //entity to dto
            dtoList.add(new EmployeeDTO(employee));
        }
        return dtoList;
    }
}
