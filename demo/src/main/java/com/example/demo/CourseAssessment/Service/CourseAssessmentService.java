package com.example.demo.CourseAssessment.Service;

import com.example.demo.CourseAssessment.model.CourseAssessment;
import com.example.demo.CourseAssessment.repository.CourseAssessmentRepository;
import com.example.demo.Professor.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAssessmentService {

    private final CourseAssessmentRepository courseAssessmentRepository;

    @Autowired
    public CourseAssessmentService(CourseAssessmentRepository courseAssessmentRepository) {
        this.courseAssessmentRepository = courseAssessmentRepository;
    }

    public List<CourseAssessment> getAllCourseAssessments() {
        return courseAssessmentRepository.findAll();
    }

    public CourseAssessment finbyID(Long id) {
        return courseAssessmentRepository.findById(id).orElse(null);
    }


    public CourseAssessment createCourseAssessment(CourseAssessment courseAssessment) {
        return courseAssessmentRepository.save(courseAssessment);
    }
}
