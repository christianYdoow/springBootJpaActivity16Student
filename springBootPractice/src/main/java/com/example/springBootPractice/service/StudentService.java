package com.example.springBootPractice.service;

import com.example.springBootPractice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    String addStudent(String studentFirstName, String studentLastName, String studentEmail, String studentCourse);

    List<Student> getAllStudent();

    Optional<Student> getStudentById(Long id);


}
