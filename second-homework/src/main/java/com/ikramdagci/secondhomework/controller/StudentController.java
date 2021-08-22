package com.ikramdagci.secondhomework.controller;


import com.ikramdagci.secondhomework.model.Student;
import com.ikramdagci.secondhomework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        return new ResponseEntity<Student>(studentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student addStudent(Student student) {
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id){
        Student willDeleted = studentService.findById(id);
        studentService.deleteById(id);
        return new ResponseEntity<>(willDeleted,HttpStatus.OK);
    }




}
