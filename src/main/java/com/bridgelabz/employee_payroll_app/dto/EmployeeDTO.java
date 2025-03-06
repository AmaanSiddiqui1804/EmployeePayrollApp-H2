package com.bridgelabz.employee_payroll_app.dto;

import com.bridgelabz.employee_payroll_app.model.Employee;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Data transfer object for Employee
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;

    @Min(value = 5000, message = "Salary must be at least 5000")
    private double salary;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
    private String gender;

    @NotNull(message = "Start date is required")
    private String startDate; // YYYY-MM-DD format

    private String note; // Optional field, no validation needed

    private String profilePic; // Can be null (no validation)

    @NotEmpty(message = "Department must not be empty")
    private List<String> department; // Employee can have multiple departments


    // Constructor to convert Employee → EmployeeDTO
    public EmployeeDTO(Employee employee) {
        if (employee != null) {
            this.name = employee.getName();
            this.salary = employee.getSalary();

        }
    }
}


    /*
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

     */

