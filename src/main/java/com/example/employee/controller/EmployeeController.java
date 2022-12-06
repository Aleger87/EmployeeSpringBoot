package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeServiceImpl.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeServiceImpl.addEmployee(employeeRequest);
    }

    @GetMapping("employees/salary/sum")
    public int getSalarySum() {
      return   this.employeeServiceImpl.getSalarySum();
    }

    @GetMapping("employees/salary/min")
    public Employee getSalaryMin() {
      return   this.employeeServiceImpl.getSalaryMin();
    }

    @GetMapping("employees/salary/max")
    public Employee getSalaryMax() {
      return   this.employeeServiceImpl.getSalaryMax();
    }

    @GetMapping("employees/high-salary")
    public Collection<Employee> getSalaryAvg() {
      return   this.employeeServiceImpl.getSalaryAvg();
    }
}
