// 🚩 Dada Ki Jay Ho 🚩



package com.example.studentmanagementlearning.controllers;

import com.example.studentmanagementlearning.modesl.Student;
import com.example.studentmanagementlearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String init(){
        return "Dada Ki Jay Ho";
    }

    @GetMapping("/students")
    public List<Student> getListStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        boolean isExists = studentRepository.existsById(student.getId());
        if(!isExists){
            studentRepository.save(student);
            return "Record Saved Successfully!";
        }else{
            return "Student already Exists!";
        }
    }

    @PutMapping("/student/{id}")
    public String editStudent(@PathVariable Integer id, @RequestBody Student student){
        Student oldStudent = studentRepository.findById(id).get();
        oldStudent.setName(student.getName());
        oldStudent.setAddress(student.getAddress());
        studentRepository.save(oldStudent);
        return "Record Updated Successfully!";
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id){
        boolean isExists = studentRepository.existsById(id);
        if(isExists){
            studentRepository.deleteById(id);
            return "Record Deleted Successfully!";
        }else{
            return "Student Not Exists!";
        }
    }

}
