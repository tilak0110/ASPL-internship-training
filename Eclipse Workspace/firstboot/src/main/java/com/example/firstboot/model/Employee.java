package com.example.firstboot.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int empId;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int empId, double salary, String name) {
        this.empId = empId;
        this.salary = salary;
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
