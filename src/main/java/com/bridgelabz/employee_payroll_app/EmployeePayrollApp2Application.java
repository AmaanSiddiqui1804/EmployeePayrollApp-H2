package com.bridgelabz.employee_payroll_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j  // Enables logging using Lombok
public class EmployeePayrollApp2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollApp2Application.class, args);

		// Logs the active environment (dev, prod, etc.)
		log.info("Employee Payroll App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));

	}
}
