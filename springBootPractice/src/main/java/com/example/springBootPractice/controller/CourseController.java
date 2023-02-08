package com.example.springBootPractice.controller;


import com.example.springBootPractice.model.Course;
import com.example.springBootPractice.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private final CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @PostMapping(path = "/courses")
    public @ResponseBody String addCourse(@RequestParam String name,
                                          @RequestParam String description) {
        return courseServiceImpl.addCourse(name, description);
    }

    //Retrieve all course from the database
    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {
        return courseServiceImpl.getAllCourses();
    }

    //Get Specific course by Id
    @GetMapping(path = "/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseServiceImpl.findCourseById(id);
    }

    //Delete a specific course with specified id
    @DeleteMapping(path = "/delete_course/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseServiceImpl.deleteCourseById(id);
    }

    //Update the Specific Course using id as path variable
    @PutMapping(path = "update_course/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setCourseId(id);
        return courseServiceImpl.updateCourse(id, course);
    }
}
