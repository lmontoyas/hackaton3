package com.example.demo.Course.model;

import com.example.demo.CourseType.model.CourseType;
import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer credits;

    private String code;

    private String HRGroup;

    private Integer cycle;

    private String VRGroup;

    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;

    public Course() {
    }

    public Course(String name, Integer credits, String code, String HRGroup, Integer cycle, String VRGroup, CourseType courseType) {
        this.name = name;
        this.credits = credits;
        this.code = code;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.VRGroup = VRGroup;
        this.courseType = courseType;
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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHRGroup() {
        return HRGroup;
    }

    public void setHRGroup(String HRGroup) {
        this.HRGroup = HRGroup;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getVRGroup() {
        return VRGroup;
    }

    public void setVRGroup(String VRGroup) {
        this.VRGroup = VRGroup;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
