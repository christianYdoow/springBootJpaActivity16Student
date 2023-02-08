package com.example.springBootPractice.service;


import com.example.springBootPractice.model.Student;
import com.example.springBootPractice.repository.CourseRepository;
import com.example.springBootPractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;


    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public String addStudent(String studentFirstName, String studentLastName, String studentEmail,String bday, String studentCourse ,String studentLevel){
        Student student = new Student();
        student.setStudentFirstName(studentFirstName);
        student.setStudentLastName(studentLastName);
        student.setStudentEmail(studentEmail);
        student.setBday(bday);
        student.setStudentCourse(studentCourse);
        student.setStudentLevel(studentLevel);
        studentRepository.save(student);

        System.out.println(studentRepository.save(student));


        return "saved";

    }
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student update(long id, Student student) {
        student.setId(id);
        return  studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student enrolStudent(Long id, Long course_id) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().add(courseRepository.findById(course_id).get());
        studentRepository.save(student);
        return student;
    }
    @Override
    public Student dropStudent(Long id, Long course_id) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().remove(courseRepository.findById(course_id).get());
        studentRepository.save(student);
        return student;
    }
}
