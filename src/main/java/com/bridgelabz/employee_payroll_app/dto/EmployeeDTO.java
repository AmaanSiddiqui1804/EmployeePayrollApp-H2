package com.bridgelabz.employee_payroll_app.dto;

import com.bridgelabz.employee_payroll_app.model.Employee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;
    @NotEmpty(message = "Department cannot be empty!")
    private String department;
    @Min(value = 5000, message = "Salary must be at least 5000")
    private double salary;

    // Constructor to convert Employee → EmployeeDTO
    public EmployeeDTO(Employee employee) {
        if (employee != null) {
            this.name = employee.getName();
            this.department = employee.getDepartment();
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

