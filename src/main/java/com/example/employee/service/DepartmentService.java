package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public Collection<Employee> getAllEmployeesByDepartment(Integer id);

    public Integer getSalarySumByDepartment(Integer id);

    public Integer getSalaryMaxByDepartment(Integer id);

    public Integer getSalaryMinByDepartment(Integer id);

    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment();

}
