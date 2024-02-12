package com.stech.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stech.Entity.Employee;
import com.stech.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	//Create
	@PostMapping("/employees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return service.saveEmployees(employees);
	}

	//Read
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}

	@PostMapping("/employees/csv")
    public String generateCSV() {
        List<Employee> employees = service.getEmployees();
        String csvFileName = "employees.csv";

        try (FileWriter writer = new FileWriter(csvFileName)) {
            // Write CSV header
            writer.append("EMP_ID,FIRST_NAME,LAST_NAME,EMAIL\n");
            // Write CSV content
            for (Employee employee : employees) {
                writer.append(String.format("%d,%s,%s,%s\n",
                        employee.getEmpId(), employee.getFirstName(),
                        employee.getLastName(), employee.getEmail()));
            }
            return "CSV generated successfully!";
        } catch (IOException e) {
            return "Error occurred while generating CSV: " + e.getMessage();
        }
    }
}


