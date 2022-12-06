package com.example.employee.record;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class EmployeeRequest {

    private  String firstName;
    private  String lastName;
    private  int department;
    private  int salary;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkData(firstName);
        this.firstName = StringUtils.capitalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkData(lastName);
        this.lastName = StringUtils.capitalize(lastName);
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private void checkData(String string) {
        if (StringUtils.isBlank(string) || !StringUtils.isAlpha(string)) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return  "{firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id + "}";
    }
}
