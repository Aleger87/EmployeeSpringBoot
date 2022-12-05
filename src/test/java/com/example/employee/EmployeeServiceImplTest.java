package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


public class EmployeeServiceImplTest {

    private static EmployeeServiceImpl employeeService = new EmployeeServiceImpl() ;

    private static EmployeeRequest employeeRequest = new EmployeeRequest();
    private static EmployeeRequest employeeRequest1 = new EmployeeRequest();
    private static EmployeeRequest employeeRequest2 = new EmployeeRequest();

    private static List<EmployeeRequest> actualEmployees;



    @BeforeAll
    public static void setUp() {
        //новый сотрудник
        employeeRequest.setFirstName("Иван");
        employeeRequest.setLastName("Иванов");
        employeeRequest.setDepartment(1);
        employeeRequest.setSalary(1000);
        employeeRequest.setId(1);

        //дублирование
        employeeRequest1.setFirstName("Иван");
        employeeRequest1.setLastName("Иванов");
        employeeRequest1.setDepartment(1);
        employeeRequest1.setSalary(2000);
        employeeRequest1.setId(2);

        //с маленькой буквы
        employeeRequest2.setFirstName("иван");
        employeeRequest2.setLastName("иванов");
        employeeRequest2.setDepartment(2);
        employeeRequest2.setSalary(3000);
        employeeRequest2.setId(3);

        actualEmployees = new ArrayList<>(List.of(
                employeeRequest,
                employeeRequest1,
                employeeRequest2));


        actualEmployees.stream().forEach(e->employeeService.addEmployee(e));

    }


    @ParameterizedTest
    @MethodSource("parametersForAddTests")
    public void addEmployeeInEmployeeService() {
        employeeService.addEmployee(employeeRequest);
        Assertions.assertEquals(employeeService.employees.get(1).toString(), employeeRequest.toString());
    }

    @Test
    public void addEmployee() {
        Assertions.assertEquals(employeeService.employees.get(1).toString(), employeeRequest.toString());
    }

    @Test
    public void checkWordSmallLetter(){
        Assertions.assertEquals("Иван", employeeRequest2.getFirstName());
        Assertions.assertEquals("Иванов", employeeRequest2.getLastName());
    }

    @Test
    public void getAllEmployees() {
        List<EmployeeRequest> actual = new ArrayList<>(actualEmployees);
        List<Employee> expected = new ArrayList<>(employeeService.employees.values());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getSalarySum() {
        int actual = actualEmployees.stream().mapToInt(e -> e.getSalary()).sum();
        int expected = employeeService.employees.values().stream().mapToInt(e -> e.getSalary()).sum();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSalaryMin() {
        Comparator<EmployeeRequest> comparatorEmployeeRequest = Comparator.comparing(EmployeeRequest::getSalary);
        EmployeeRequest actual = actualEmployees.stream().min(comparatorEmployeeRequest).get();
        Comparator<Employee> comparatorEmployee = Comparator.comparing(Employee::getSalary);
        Employee expected = employeeService.employees.values().stream().min(comparatorEmployee).get();
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getSalaryMax() {
        Comparator<EmployeeRequest> comparatorEmployeeRequest = Comparator.comparing(EmployeeRequest::getSalary);
        EmployeeRequest actual = actualEmployees.stream().max(comparatorEmployeeRequest).get();
        Comparator<Employee> comparatorEmployee = Comparator.comparing(Employee::getSalary);
        Employee expected = employeeService.employees.values().stream().max(comparatorEmployee).get();
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getSalaryAvg() {
        Collection<EmployeeRequest> actual = actualEmployees.stream()
                .filter(e -> e.getSalary() > employeeService.employees.values().stream().mapToDouble(y->y.getSalary()).average().getAsDouble()).toList();
        Collection<Employee> expected = employeeService.employees.values().stream()
                .filter(e -> e.getSalary() > employeeService.employees.values().stream().mapToDouble(y->y.getSalary()).average().getAsDouble()).toList();
        Assertions.assertEquals(expected.toString(), actual.toString());
    }




    public static Stream<Arguments> parametersForAddTests() {
                return Stream.of(
                Arguments.of(employeeRequest),
                Arguments.of(employeeRequest1),
                Arguments.of(employeeRequest2));
    }
}
