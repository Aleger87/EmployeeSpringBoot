package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("employees/salary/sum")
    public int getSalarySum() {
      return   this.employeeService.getSalarySum();
    }

    @GetMapping("employees/salary/min")
    public int getSalaryMin() {
      return   this.employeeService.getSalaryMin();
    }

    @GetMapping("employees/salary/max")
    public int getSalaryMax() {
      return   this.employeeService.getSalaryMax();
    }

    @GetMapping("employees/high-salary")
    public Collection<Employee> getSalaryAvg() {
      return   this.employeeService.getSalaryAvg();
    }
}
