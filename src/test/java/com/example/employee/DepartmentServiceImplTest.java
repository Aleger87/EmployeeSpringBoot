package com.example.employee;

import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.DepartmentServiceImpl;
import com.example.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private static EmployeeRequest employeeRequest = new EmployeeRequest();
    private static EmployeeRequest employeeRequest1 = new EmployeeRequest();
    private static EmployeeRequest employeeRequest2 = new EmployeeRequest();

    private List<EmployeeRequest> actualEmployees;

    @BeforeEach
    public void setUp() {
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

    }






}
