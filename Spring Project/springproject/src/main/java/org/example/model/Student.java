package org.example.model;

public class Student implements Person{
    private String name;
    private int marks;

    public Student() {
        System.out.println("STUDENT CONSTRUCTOR");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void test(){
        System.out.println("Working fine");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
