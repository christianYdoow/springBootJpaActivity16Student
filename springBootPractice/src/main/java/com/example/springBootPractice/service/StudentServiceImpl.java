package com.example.springBootPractice.service;


import com.example.springBootPractice.model.Student;
import com.example.springBootPractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(String studentFirstName, String studentLastName, String studentEmail, String studentCourse){
        Student student = new Student();
        student.setStudentFirstName(studentFirstName);
        student.setStudentLastName(studentLastName);
        student.setStudentEmail(studentEmail);
        student.setStudentCourse(studentCourse);
        studentRepository.save(student);

        System.out.println(studentRepository.save(student));

        return "saved";

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
