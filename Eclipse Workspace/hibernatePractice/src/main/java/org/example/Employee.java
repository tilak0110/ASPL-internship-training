package org.example;

import jakarta.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    private double salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")  // Foreign Key
    private Address address;
    @ManyToOne
    @JoinColumn(name = "department_id")  // Foreign Key in Employee table
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private Company company;

    public Employee() {}

    public Employee(String name, double salary,Address address) {

        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
