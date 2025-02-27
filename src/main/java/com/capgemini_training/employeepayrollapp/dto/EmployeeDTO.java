package com.capgemini_training.employeepayrollapp.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
    //attribute
    private int id;
    //add validation annotation
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "employee name is not valid")
    private String name;
    private long salary;
    //adding more properties
    private String gender;
    private String startDate;
    private String profilePic;
    private List<String> department;
}
