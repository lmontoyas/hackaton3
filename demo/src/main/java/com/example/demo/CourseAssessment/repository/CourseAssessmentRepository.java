package com.example.demo.CourseAssessment.repository;

import com.example.demo.CourseAssessment.model.CourseAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment,Long> {
}
