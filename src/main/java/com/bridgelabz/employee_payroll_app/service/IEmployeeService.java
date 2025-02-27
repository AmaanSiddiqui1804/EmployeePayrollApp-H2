package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import java.util.List;

// UC-2-Service
public interface IEmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);   // To add employee
    List<EmployeeDTO> getAllEmployees();  // Get all employee details
    EmployeeDTO getEmployeeById(Long id);  // Get Employee by ID
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);  // Update Employee
    void deleteEmployee(Long id);  // Delete Employee
}
