package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll_app.model.Employee;
import com.bridgelabz.employee_payroll_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// UC-2-Service
@Service  // Marks this as a Service Component to handle business logic
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDTO(savedEmployee);  // Convert Employee to EmployeeDTO
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDTO::new)  // Convert each Employee to EmployeeDTO
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return new EmployeeDTO(employee); // Convert Employee to EmployeeDTO
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);
        return new EmployeeDTO(updatedEmployee); // Convert Employee to EmployeeDTO
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
