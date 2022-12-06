package com.example.employee.model;

import java.util.Objects;

public class Employee {
    private static int count=1;
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;
    private final int id;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
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
