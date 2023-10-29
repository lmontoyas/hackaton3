package com.example.demo.CourseAssessment.controller;

import com.example.demo.CourseAssessment.Service.CourseAssessmentService;
import com.example.demo.CourseAssessment.model.CourseAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-assessments")
public class CourseAssessmentController {

    private final CourseAssessmentService courseAssessmentService;

    @Autowired
    public CourseAssessmentController(CourseAssessmentService courseAssessmentService) {
        this.courseAssessmentService = courseAssessmentService;
    }

    @GetMapping
    public List<CourseAssessment> getAllCourseAssessments() {
        return courseAssessmentService.getAllCourseAssessments();
    }

    @PostMapping
    public CourseAssessment createCourseAssessment(@RequestBody CourseAssessment courseAssessment) {
        return courseAssessmentService.createCourseAssessment(courseAssessment);
    }
}
