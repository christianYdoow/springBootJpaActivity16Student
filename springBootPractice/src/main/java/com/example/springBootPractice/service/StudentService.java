package com.example.springBootPractice.service;

import com.example.springBootPractice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    String addStudent(String studentFirstName, String studentLastName, String studentEmail,String bday, String studentCourse,String studentLevel);

    List<Student> getAllStudent();

    Optional<Student> getStudentById(long id);

     Student update(long id, Student student);

    public void delete(long id);

    Student enrolStudent(Long id, Long course_id);

    Student dropStudent(Long id, Long course_id);



}
