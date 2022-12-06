package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.DepartmentServiceImpl;
import com.example.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private static EmployeeRequest employeeRequest = new EmployeeRequest();
    private static EmployeeRequest employeeRequest1 = new EmployeeRequest();
    private static EmployeeRequest employeeRequest2 = new EmployeeRequest();

    private List<Employee> actualEmployees;
    private Integer department;

    @BeforeEach
    public void  setUp() {
        department = 1;
        Employee employee = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee1 = new Employee("Иван1", "Иванов1", 1, 2000);
        Employee employee2 = new Employee("Иван2", "Иванов2", 1, 3000);
        Employee employee3 = new Employee("Иван2", "Иванов3", 2, 4000);
        Employee employee4 = new Employee("Иван2", "Иванов4", 2, 5000);

        actualEmployees = new ArrayList<>(List.of(
                employee,
                employee1,
                employee2,
                employee3,
                employee4
        ));

        when(employeeService.getAllEmployees()).thenReturn(actualEmployees);

    }

    @Test
    public void getAllEmployeesByDepartment() {
        List<Employee> actual = actualEmployees.stream()
                .filter(e->e.getDepartment() == department)
                .toList();
        List<Employee> expected = employeeService.getAllEmployees().stream()
                .filter(e->e.getDepartment() == department)
                .toList();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSalarySumByDepartment() {
        Integer actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).sum();
        Integer expected = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).sum();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSalaryMaxByDepartment() {
        Integer actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).max().getAsInt();
        Integer expected = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).max().getAsInt();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSalaryMinByDepartment() {
        Integer actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).min().getAsInt();
        Integer expected = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(t -> t.getSalary()).min().getAsInt();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getGroupEmployeesByDepartment() {
        Map<Integer, List<Employee>> actual = actualEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Map<Integer, List<Employee>> expected = employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Assertions.assertEquals(expected, actual);
    }

}
