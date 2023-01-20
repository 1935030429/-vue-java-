package com.example.term.Dao;

import com.example.term.model.Student;
import com.example.term.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addTeacher(Teacher teacher){
       return jdbcTemplate.update("INSERT INTO teacher(name,age,sex,position,image,edubackground) VALUES(?,?,?,?,?,?)",teacher.getName(),teacher.getAge(),teacher.getSex(),teacher.getPosition(),teacher.getImage(),teacher.getEdubackground());
    }
    public int updateTeacher(Teacher teacher){
        return jdbcTemplate.update("UPDATE teacher SET name=?,age=?,sex=?,position =?,image=?,edubackground=? WHERE id=?",teacher.getName(),teacher.getAge(),teacher.getSex(),teacher.getPosition(),teacher.getImage(),teacher.getEdubackground(),teacher.getId());
    }
    public int deleteTeacherById(Integer id){
        return jdbcTemplate.update("DELETE from teacher WHERE id=?",id);
    }
    public Teacher getTeacherById(Integer id){
        return jdbcTemplate.queryForObject("select * from teacher where id=?",new BeanPropertyRowMapper<>(Teacher.class),id);
    }
    public List<Teacher> getAllTeachers(){
        return jdbcTemplate.query("select * from teacher",new BeanPropertyRowMapper<>(Teacher.class));
    }
    public List<Teacher> getTeachersbyKey(String key){
        return jdbcTemplate.query("select * from teacher where name like '%"+key+"%' or position like '%"+key+"%' or edubackground like '%"+key+"%'",new BeanPropertyRowMapper<>(Teacher.class));
    }
}
