package com.stech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.Entity.Employee;
import com.stech.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
  
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
  
    public List<Employee> saveEmployees(List<Employee> employees) {
        return repository.saveAll(employees);
    }
  
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

}
