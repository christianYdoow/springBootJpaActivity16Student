package com.example.springBootPractice.controller;

import com.example.springBootPractice.model.Student;
import com.example.springBootPractice.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;


    }

    @PostMapping("/addStudent")
    public @ResponseBody String addStudent(@RequestParam String studentFirstName,
                              @RequestParam String studentLastName,
                              @RequestParam String studentEmail,
                              @RequestParam String studentCourse){
        return studentServiceImpl.addStudent(studentFirstName,studentLastName,studentEmail,studentCourse);
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentServiceImpl.getStudentById(id);
    }


    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return studentServiceImpl.getAllStudent();
    }
}
