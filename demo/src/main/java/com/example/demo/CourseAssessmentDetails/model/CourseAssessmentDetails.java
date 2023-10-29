package com.example.demo.CourseAssessmentDetails.model;

import com.example.demo.CourseAssessment.model.CourseAssessment;
import com.example.demo.Professor.model.Professor;
import com.example.demo.Student.model.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "course_assessment_details")
public class CourseAssessmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;

    private String section;

    private String sectionGroup;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_assessment_id")
    private CourseAssessment courseAssessment;

    public CourseAssessmentDetails() {
    }

    public CourseAssessmentDetails(String score, String section, String sectionGroup, Student student, Professor professor, CourseAssessment courseAssessment) {
        this.score = score;
        this.section = section;
        this.sectionGroup = sectionGroup;
        this.student = student;
        this.professor = professor;
        this.courseAssessment = courseAssessment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionGroup() {
        return sectionGroup;
    }

    public void setSectionGroup(String sectionGroup) {
        this.sectionGroup = sectionGroup;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public CourseAssessment getCourseAssessment() {
        return courseAssessment;
    }

    public void setCourseAssessment(CourseAssessment courseAssessment) {
        this.courseAssessment = courseAssessment;
    }
}
