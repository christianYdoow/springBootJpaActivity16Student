package com.example.springBootPractice.service;

import com.example.springBootPractice.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public String addCourse(String name, String description);

    public List<Course> getAllCourses();

    public Optional<Course> findCourseById(Long id);

    public void deleteCourseById(Long id);

    public Course updateCourse(long id, Course course);

}
