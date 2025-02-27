package com.capgemini_training.employeepayrollapp.model;

import jakarta.persistence.*;
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
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private long salary;
    //add more properties
    @Column(name = "gender")
    private String gender;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "note")
    private String note;
    @Column(name = "profilePic")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> departments;
}
