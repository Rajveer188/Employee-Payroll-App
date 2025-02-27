package com.capgemini_training.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
    //attribute
    @NotNull
    private int id;
    //add validation annotation
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "employee name is not valid")
    private String name;
    @Min(value = 15000, message = "min salary should be more than 15000")
    private long salary;
    //adding more properties
    @Pattern(regexp = "female|male", message = "gender needs to be female or male")
    private String gender;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "start date should not be null")
    private LocalDate startDate;
    @NotBlank(message = "profile pic cannot be empty")
    private String profilePic;
    @NotNull(message = "department should not be null")
    @Size(min = 1, message = "employee should have at least one department")
    private List<String> departments;
    @NotBlank(message = "note should not be empty")
    private String note;
}
