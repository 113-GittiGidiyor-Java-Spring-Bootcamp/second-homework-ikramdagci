package com.ikramdagci.secondhomework.controller;


import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
        return new ResponseEntity<Course>(courseService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course addCourse(Course course) {
        return courseService.save(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable Long id){
        Course willDeleted = courseService.findById(id);
        courseService.deleteById(id);
        return new ResponseEntity<>(willDeleted,HttpStatus.OK);
    }
}
