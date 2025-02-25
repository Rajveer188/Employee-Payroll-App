package com.capgemini_training.employeepayrollapp.service;

import com.capgemini_training.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini_training.employeepayrollapp.model.EmployeeEntity;
import com.capgemini_training.employeepayrollapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EmployeeService {
    //attribute
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    //constructor
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    //method to add employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        //save entity in the database
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        //convert entity to dto and return
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
    //method to get employee by id
    public EmployeeDTO getEmployeeById(int id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //convert entity to dto and return
        if(employeeEntity == null){
            return null;
        }
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
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
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
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
            EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
