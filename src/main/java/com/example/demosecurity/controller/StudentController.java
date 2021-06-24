package com.example.demosecurity.controller;

import com.example.demosecurity.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static List<Student> students = Arrays.asList(
            new Student(1,"Yuriy")

    );

    @GetMapping(path = "/{id}")
    public Student get(@PathVariable("id") long id){
        return students.stream()
                .filter(student -> id == student.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
    }
}
