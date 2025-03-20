package com.bridgelabz.employee_payroll_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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

// Global CORS Configuration (Added Below)
@Configuration
class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Allow all API endpoints
						.allowedOrigins("http://localhost:4200") // Allow Angular frontend
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Allow HTTP methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true);
			}
		};
	}
}
