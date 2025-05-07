package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    public Student(List<Course> courses, String name) {
        this.courses = courses;
        this.name = name;
    }

    @ManyToMany
            @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))

    List<Course> courses;

}
