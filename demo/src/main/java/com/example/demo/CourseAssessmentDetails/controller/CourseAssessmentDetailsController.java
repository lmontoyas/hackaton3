package com.example.demo.CourseAssessmentDetails.controller;

import com.example.demo.CourseAssessment.Service.CourseAssessmentService;
import com.example.demo.CourseAssessment.model.CourseAssessment;
import com.example.demo.CourseAssessmentDetails.Service.CourseAssessmentDetailsService;
import com.example.demo.CourseAssessmentDetails.model.CourseAssessmentDetails;
import com.example.demo.CourseAssessmentDetails.repository.CourseAssessmentDetailsRepository;
import com.example.demo.Professor.model.Professor;
import com.example.demo.Professor.Service.ProfessorService;
import com.example.demo.Student.model.Student;
import com.example.demo.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {


    private final CourseAssessmentDetailsService courseAssessmentDetailsService;

    @Autowired
    private CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;


    @Autowired
    public CourseAssessmentDetailsController(CourseAssessmentDetailsService courseAssessmentDetailsService, StudentService studentService, ProfessorService professorService, CourseAssessmentService courseAssessmentService) {
        this.courseAssessmentDetailsService = courseAssessmentDetailsService;
    }

    @GetMapping
    public List<CourseAssessmentDetails> getAllCourseAssessmentDetails() {
        return courseAssessmentDetailsService.getAllCourseAssessmentDetails();
    }

    @PostMapping
    public ResponseEntity<CourseAssessmentDetails> createCourseAssessmentDetails(@RequestBody CourseAssessmentDetails courseAssessmentDetails) {
        CourseAssessmentDetails createdDetails = courseAssessmentDetailsService.createCourseAssessmentDetails(courseAssessmentDetails);
        return new ResponseEntity<>(createdDetails, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> getCourseAssessmentDetailsById(@PathVariable Long id) {
        CourseAssessmentDetails courseAssessmentDetails = courseAssessmentDetailsService.getCourseAssessmentDetailsById(id);
        if (courseAssessmentDetails != null) {
            return new ResponseEntity<>(courseAssessmentDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> updateCourseAssessmentDetails(
            @PathVariable Long id,
            @RequestBody CourseAssessmentDetails updatedCourseAssessmentDetails) {

        CourseAssessmentDetails existe = courseAssessmentDetailsService.getCourseAssessmentDetailsById(id);

        if (existe != null) {
            if (courseAssessmentDetailsService.containsNullValues(updatedCourseAssessmentDetails)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            existe.setScore(updatedCourseAssessmentDetails.getScore());
            existe.setSection(updatedCourseAssessmentDetails.getSection());
            existe.setSectionGroup(updatedCourseAssessmentDetails.getSectionGroup());
            existe.setStudent(updatedCourseAssessmentDetails.getStudent());
            existe.setProfessor(updatedCourseAssessmentDetails.getProfessor());
            existe.setCourseAssessment(updatedCourseAssessmentDetails.getCourseAssessment());
            courseAssessmentDetailsRepository.save(existe);
            return new ResponseEntity<>(existe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public String deleteCourseAssessmentDetails(@PathVariable Long id) {
        if (courseAssessmentDetailsService.deleteCourseAssessmentDetails(id)) {
            return "Item " + id + " deleted";
        } else {
            return "Item with ID " + id + " not found";
        }
    }
}
