package com.bridgelabz.employee_payroll_app.model;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> department;


    // Constructor using DTO
    public Employee(EmployeeDTO employeeDTO) {
        if (employeeDTO != null) {
            this.name = employeeDTO.getName();
            this.salary = employeeDTO.getSalary();
        }
    }
}

/*
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

 */

