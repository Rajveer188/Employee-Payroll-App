package com.capgemini_training.employeepayrollapp.service;

import com.capgemini_training.employeepayrollapp.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService{
    //abstract method for employee service
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    public EmployeeDTO getEmployeeById(int id);
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
    public void deleteEmployee(int id);
    public List<EmployeeDTO> getAllEmployees();
    public List<EmployeeDTO> getEmployeeByDepartment(String department);
}
