package com.bridgelabz.employee_payroll_app.repository;

import com.bridgelabz.employee_payroll_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("Select e FROM Employee e WHERE :department MEMBER OF e.department")
    List<Employee> findEmployeesByDepartment(@Param("department") String department);

}
