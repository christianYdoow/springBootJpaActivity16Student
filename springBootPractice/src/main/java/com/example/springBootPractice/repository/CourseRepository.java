package com.example.springBootPractice.repository;

import com.example.springBootPractice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
