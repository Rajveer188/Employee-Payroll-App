package com.capgemini_training.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

//Employee model
@Component
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    //attributes
    @Id
    private int id;
    private String name;
    private double salary;

    //constructors
    public EmployeeEntity(){}

    public EmployeeEntity(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
