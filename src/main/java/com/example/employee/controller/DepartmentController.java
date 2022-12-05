package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    //возвращает список сотрудников по департаменту
    @GetMapping("/{id}/employees")
    public Collection<Employee> getAllEmployeesByDepartment(@PathVariable(value = "id") Integer id) {
        return this.departmentServiceImpl.getAllEmployeesByDepartment(id);
    }

    //возвращает сумму зарплат по департаменту
    @GetMapping("/{id}/salary/sum")
   public Integer getSalarySumByDepartment (@PathVariable(value = "id") Integer id) {
        return this.departmentServiceImpl.getSalarySumByDepartment(id);
    }

    //возвращает максимальную зарплату по департаменту
    @GetMapping("/{id}/salary/max")
    public Integer getSalaryMaxByDepartment(@PathVariable(value = "id") Integer id) {
        return   this.departmentServiceImpl.getSalaryMaxByDepartment(id);
    }

    // возвращает минимальную зарплату по департаменту
    @GetMapping("/{id}/salary/min")
    public Integer getSalaryMinByDepartment(@PathVariable(value = "id") Integer id) {
        return   this.departmentServiceImpl.getSalaryMinByDepartment(id);
    }

    //возвращает сотрудников, сгруппированных по отделам
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment () {
        return this.departmentServiceImpl.getGroupEmployeesByDepartment();
    }
}
