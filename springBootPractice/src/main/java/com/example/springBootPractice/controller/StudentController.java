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

    @PostMapping("/students")
    public @ResponseBody String addStudent(@RequestParam String studentFirstName,
                                           @RequestParam String studentLastName,
                                           @RequestParam String studentEmail,
                                           @RequestParam String bday,
                                           @RequestParam String studentCourse,
                                           @RequestParam String studentLevel){
        return studentServiceImpl.addStudent(studentFirstName,studentLastName,studentEmail,bday,studentCourse,studentLevel);
    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentServiceImpl.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentServiceImpl.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody Student student){
        return studentServiceImpl.update(id,student);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id ){
        studentServiceImpl.delete(id);
    }

    @PutMapping("/students/{id}/enroll/{course_id}")
    public Student enrolStudent(@PathVariable("id") Long id, @PathVariable("course_id") Long course_id ) {
        return studentServiceImpl.enrolStudent(id, course_id);
    }
    @DeleteMapping("/students/{id}/drop/{course_id}")
    public Student dropStudent(@PathVariable("id") Long id, @PathVariable("course_id") Long course_id ) {
        studentServiceImpl.dropStudent(id, course_id);
        return studentServiceImpl.dropStudent(id,course_id);
    }

}
