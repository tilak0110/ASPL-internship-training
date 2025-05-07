package org.example.model;

public class Employee implements Person{
    private String name;
    private int age;
    private Student student;

    public Employee() {
        System.out.println("EMPLOYEE CONSTRUCTOR");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
//    public Employee(String name,int age) {
//        this.name = name;
//        this.age=age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void test(){
        System.out.println("Working fine");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

