package com.example.employee.service;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

  EmployeeServiceImpl employeeServiceImpl;


    @Override
    public Collection<Employee> getAllEmployeesByDepartment(Integer id) {
        return employeeServiceImpl.employees.values().stream().filter(e->e.getDepartment() == id).toList();
    }

    @Override
    public Integer getSalarySumByDepartment(Integer id) {
       return employeeServiceImpl.employees.values().stream()
                .filter(e->e.getDepartment() == id).mapToInt(t->t.getSalary()).sum();
    }

    @Override
    public Integer getSalaryMaxByDepartment(Integer id) {
       return employeeServiceImpl.employees.values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(t -> t.getSalary()).max().getAsInt();
    }

    @Override
    public Integer getSalaryMinByDepartment(Integer id) {
        return employeeServiceImpl.employees.values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(t -> t.getSalary()).min().getAsInt();
    }

    @Override
    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment() {
        return employeeServiceImpl.employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
