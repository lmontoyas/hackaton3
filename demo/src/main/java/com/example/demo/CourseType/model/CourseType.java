package com.example.demo.CourseType.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_type")
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CourseType() {
    }

    public CourseType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
