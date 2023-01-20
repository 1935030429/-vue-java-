package com.example.term.Controller;

import com.example.term.Service.StudentService;
import com.example.term.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/studentOps")
    public List<Student> studentOps() {
        List<Student> studentOps = studentService.getAllStudents();
        for(int i = 0;i < 4;i++) {
            System.out.println("Get>>>" + studentOps.get(i) + "\n");
        }
        return studentOps;
    }
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable("id") Integer id){
        int i = studentService.deleteStudentById(id);
        return id;
    }
    @PostMapping("/update")
    public int update(@RequestBody Student student){
        int i = studentService.updateStudent(student);
        System.out.println("update>>>"+i);
        return i;
    }
    @PostMapping("/add")
    public String add(@RequestBody Student student){
        int i = studentService.addStudent(student);
        if(student!=null) return "success";
        else return "error";
    }
    @GetMapping("/ketones/{id}")
    public Student ketones(@PathVariable("id") Integer id){
        Student stu;
        stu = studentService.getStudentById(id);
        return stu;
    }
}
