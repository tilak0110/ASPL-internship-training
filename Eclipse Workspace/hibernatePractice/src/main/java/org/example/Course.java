package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;

    public Course(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "courses")
    List<Student> students;
}
