package com.capgemini_training.employeepayrollapp.controller;

import com.capgemini_training.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini_training.employeepayrollapp.model.EmployeeEntity;
import com.capgemini_training.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller for employee payroll service
@RestController
@RequestMapping("/employeeservice")
@Slf4j
public class EmployeeController {

    EmployeeService employeeService;

    //constructor
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //get methods
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id){
        log.info("receive api request for get employee {} details", id);
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        //return response
        return ResponseEntity.ok(employeeDTO);
    }
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        log.info("receive api request to get all employees details");
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        //return response
        return ResponseEntity.ok(employeeDTOList);
    }
    //post method
    @PostMapping("/post")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee){
        log.info("receive api request to post a new employee");
        EmployeeDTO employeeDTO = employeeService.addEmployee(employee);
        //return response
        return ResponseEntity.ok(employeeDTO);
    }

    //put method
    @PutMapping("/put/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employee){
        log.info("receive api request for update employee {} details", id);
        EmployeeDTO employeeDTO = employeeService.updateEmployee(id, employee);
        //return response
        return ResponseEntity.ok(employeeDTO);
    }

    //delete method
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        log.info("receive api request to delete employee {} details", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("employee deleted successfully");
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByDepartment(@PathVariable("department") String department){
        List<EmployeeDTO> employeeDTOList = null;
        employeeDTOList = employeeService.getEmployeeByDepartment(department);
        return ResponseEntity.ok(employeeDTOList);
    }
}

