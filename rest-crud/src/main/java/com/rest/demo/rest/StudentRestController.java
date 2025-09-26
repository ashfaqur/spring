package com.rest.demo.rest;

import com.rest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        this.students = new ArrayList<>();
        this.students.add(new Student("Jack", "Brown"));
        this.students.add(new Student("Georgia", "Game"));
        this.students.add(new Student("Leny", "Kavit"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId < 0 || studentId >= this.students.size()){
            throw new StudentNotFoundException("No student found for id: " + studentId);
        }
        return this.students.get(studentId);
    }


}
