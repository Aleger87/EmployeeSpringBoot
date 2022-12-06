package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;

import java.util.Collection;

public interface EmployeeService {

    public Collection<Employee> getAllEmployees();

    public Employee addEmployee(EmployeeRequest employeeRequest);

    public int getSalarySum();

    public Employee getSalaryMin();

    public Employee getSalaryMax();

    public Collection<Employee> getSalaryAvg();

}
