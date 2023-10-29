package com.example.demo.CourseType.controller;

import com.example.demo.CourseType.model.CourseType;
import com.example.demo.CourseType.Service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-types")
public class CourseTypeController {

    private final CourseTypeService courseTypeService;

    @Autowired
    public CourseTypeController(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    @GetMapping
    public List<CourseType> getAllCourseTypes() {
        return courseTypeService.getAllCourseTypes();
    }

    @PostMapping
    public CourseType createCourseType(@RequestBody CourseType courseType) {
        return courseTypeService.createCourseType(courseType);
    }
}
