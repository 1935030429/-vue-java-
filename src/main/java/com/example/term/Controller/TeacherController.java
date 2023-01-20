package com.example.term.Controller;

import com.example.term.Service.TeacherService;
import com.example.term.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/GetAllTeachers")
    public List<Teacher> GetAllTeachers(){
        List<Teacher> t;
        t = teacherService.getAllTeachers();
        return t;
    }
    @GetMapping("/GetOneTeacher/{id}")
    public Teacher GetOneTeacher(@PathVariable("id") Integer id){
        return teacherService.getTeacherById(id);
    }
    @PostMapping("/AddOneTeacher")
    public String AddOneTeacher(@RequestBody Teacher teacher){
        int i = teacherService.addTeacher(teacher);
        System.out.println("add>>>"+i);
        if(i>0) return "success";
        else return "fail";
    }
    @GetMapping("/GetTeachersByKey/{key}")
    public List<Teacher> GetTeachersByKey(@PathVariable("key") String key){
        return teacherService.getTeachersbyKey(key);
    }
}
