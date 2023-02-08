package com.example.springBootPractice.service;

import com.example.springBootPractice.model.Course;
import com.example.springBootPractice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String addCourse(String name, String description) {

        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        courseRepository.save(course);
        return "Course Successfully Added.";
    }
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    @Override
    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }
    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
    @Override
    public Course updateCourse(long id, Course course) {
        course.setCourseId(id);
        return courseRepository.save(course);
    }
}
