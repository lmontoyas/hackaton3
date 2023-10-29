package com.example.demo.CourseAssessmentDetails.Service;

import com.example.demo.CourseAssessment.Service.CourseAssessmentService;
import com.example.demo.CourseAssessment.model.CourseAssessment;
import com.example.demo.CourseAssessmentDetails.model.CourseAssessmentDetails;
import com.example.demo.CourseAssessmentDetails.repository.CourseAssessmentDetailsRepository;
import com.example.demo.Professor.Service.ProfessorService;
import com.example.demo.Professor.model.Professor;
import com.example.demo.Student.Service.StudentService;
import com.example.demo.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAssessmentDetailsService {

    private final CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;

    private final CourseAssessmentService courseAssessmentService;
    @Autowired
    public CourseAssessmentDetailsService(CourseAssessmentDetailsRepository courseAssessmentDetailsRepository, StudentService studentService, ProfessorService professorService, CourseAssessmentService courseAssessmentService) {
        this.courseAssessmentDetailsRepository = courseAssessmentDetailsRepository;
        this.studentService = studentService;
        this.professorService = professorService;
        this.courseAssessmentService = courseAssessmentService;
    }

    public List<CourseAssessmentDetails> getAllCourseAssessmentDetails() {
        return courseAssessmentDetailsRepository.findAll();
    }
    public CourseAssessmentDetails createCourseAssessmentDetails(CourseAssessmentDetails courseAssessmentDetails) {
        // Aquí puedes agregar lógica para validar o manipular los datos antes de guardar
        return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }

    public CourseAssessmentDetails getCourseAssessmentDetailsById(Long id) {
        return courseAssessmentDetailsRepository.findById(id).orElse(null);
    }
    public boolean containsNullValues(CourseAssessmentDetails updated) {
        if (updated.getStudent() == null || updated.getProfessor() == null || updated.getCourseAssessment() ==null){
            return true;
        }
        Student existeStudent = studentService.finbyID(updated.getStudent().getId());
        Professor existeProfessor = professorService.finbyID(updated.getProfessor().getId());
        CourseAssessment existeCourseAssessment = courseAssessmentService.finbyID(updated.getCourseAssessment().getId());
        if (existeStudent == null || existeProfessor == null || existeCourseAssessment == null){
            return true;
        }
        return updated.getScore() == null ||
                updated.getSection() == null ||
                updated.getSectionGroup() == null;
    }

    public boolean deleteCourseAssessmentDetails(Long id) {
        Optional<CourseAssessmentDetails> courseAssessmentDetailsOptional = courseAssessmentDetailsRepository.findById(id);
        if (courseAssessmentDetailsOptional.isPresent()) {
            courseAssessmentDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
