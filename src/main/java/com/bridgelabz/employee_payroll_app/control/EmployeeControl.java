
package com.bridgelabz.employee_payroll_app.control;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll_app.model.Employee;
import com.bridgelabz.employee_payroll_app.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks the class as a REST Controller, handling HTTP requests
@RequestMapping("/employees")  // Base URL for all
public class EmployeeControl {

    //UC-2- Service Layer Functionality
    @Autowired
    private IEmployeeService employeeService;  // Injecting the Service Layer

    /**
     * UC-3: Adding an Employee
     * This method handles adding a new employee.
     * It receives Employee data as JSON and saves it to the database.
     * URL: POST /employees/add
     */
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    /**
     * UC-2: Get All Employees
     * This method fetches all employees from the database.
     * URL: GET /employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * UC-2: Get Employee by ID
     * This method fetches an employee based on their ID.
     * If the ID is not found, it returns an error.
     * URL: GET /employees/{id}
     */
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * UC-3: Updating Employee Details
     * This method updates an existing employee's details based on ID.
     * It receives updated employee data as JSON and applies changes.
     * URL: PUT /employees/update/{id}
     */
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    /**
     * UC-3: Deleting an Employee
     * This method deletes an employee from the database based on ID.
     * URL: DELETE /employees/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}



    /* Not used anymore

    @Autowired     //Added for UC1 in section 2
    private final EmployeeRepository employeeRepository;

    //Get (Fetching all employees)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //Post (Adding new Employees)
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    //Put (Updating Employees in Employee via ID
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeDTO.getName());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    //Delete Deleting employees by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee with ID: " + id + " deleted successfully";
    }

     */
