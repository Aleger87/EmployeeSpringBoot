package com.example.employee.service;
import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Map<Integer, Employee> employees = new HashMap<>();


    @Override
    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    @Override
    public Employee addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getDepartment(), employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public int getSalarySum() {
      return this.employees.values().stream().mapToInt(e -> e.getSalary()).sum();
    }

    @Override
    public Employee getSalaryMin() {
        Comparator<Employee> comparator = Comparator.comparing( Employee::getSalary);
        Employee minObject = this.employees.values().stream().min(comparator).get();
        return minObject;


    }

    @Override
    public Employee getSalaryMax() {
        Comparator<Employee> comparator = Comparator.comparing( Employee::getSalary);
        Employee maxObject = this.employees.values().stream().max(comparator).get();
        return maxObject;

    }

    @Override
    public Collection<Employee> getSalaryAvg() {
        Collection<Employee> highSalary = this.employees.values().stream()
                .filter(e -> e.getSalary() > this.employees.values().stream().mapToDouble(y->y.getSalary()).average().getAsDouble()).toList();
        return highSalary;
    }
}
