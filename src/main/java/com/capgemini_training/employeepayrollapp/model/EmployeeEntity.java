package com.capgemini_training.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

//Employee model
@Component
@Entity
@Table(name = "employees")
public @Data class EmployeeEntity {
    //attributes
    @Id
    private int id;
    private String name;
    private long salary;
    //add more properties
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
}
