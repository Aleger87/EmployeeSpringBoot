package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("не заполнено имя");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getDepartment(), employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
      return this.employees.values().stream().mapToInt(e -> e.getSalary()).sum();
    }

    public int getSalaryMin() {
        return this.employees.values().stream().mapToInt(e -> e.getSalary()).min().getAsInt();
    }

    public int getSalaryMax() {
        return this.employees.values().stream().mapToInt(e -> e.getSalary()).max().getAsInt();
    }

    public Collection<Employee> getSalaryAvg() {
        Collection<Employee> highSalary = this.employees.values().stream()
                .filter(e -> e.getSalary() > this.employees.values().stream().mapToDouble(y->y.getSalary()).average().getAsDouble()).toList();
        return highSalary;
    }
}
