package com.example.demo.CourseType.Service;

import com.example.demo.CourseType.model.CourseType;
import com.example.demo.CourseType.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeService {

    private final CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseTypeService(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    public CourseType createCourseType(CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }
}
