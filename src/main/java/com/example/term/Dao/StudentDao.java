package com.example.term.Dao;


import com.example.term.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO student(sid,name,sex,age,college) VALUES(?,?,?,?,?)" ,student.getSid(),student.getName(),student.getSex(),student.getAge(),student.getCollege());
    }
    public int update(Student student){
        return jdbcTemplate.update("UPDATE student SET sid=?,name=?,sex=?,age=?,college=? WHERE id=?",student.getSid(),student.getName(),student.getSex(),student.getAge(),student.getCollege(),student.getId());
    }
    public int deleteStudentById(Integer id){
        return jdbcTemplate.update("DELETE from student WHERE id=?",id);
    }
    public Student getStudentById(Integer id){
        return jdbcTemplate.queryForObject("select * from student where id=?",new BeanPropertyRowMapper<>(Student.class),id);
    }
    public List<Student> getAllStudents(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }
}
