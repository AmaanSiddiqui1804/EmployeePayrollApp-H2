package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll_app.model.Employee;
import java.util.List;

//UC-2-Service
public interface IEmployeeService {

    Employee addEmployee(EmployeeDTO employeeDTO);   //To add employee
    List<Employee> getAllEmployees();  //Get all employee details
    Employee getEmployeeById(Long id);  // Get Employee by ID
    Employee updateEmployee(Long id, EmployeeDTO employeeDTO);  // Update Employee
    void deleteEmployee(Long id);  // Delete Employee

}
