package com.bridgelabz.employee_payroll_app.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private String department;
    private double salary;

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
}
