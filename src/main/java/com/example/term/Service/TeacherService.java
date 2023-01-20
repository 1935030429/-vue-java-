package com.example.term.Service;

import com.example.term.Dao.TeacherDao;
import com.example.term.model.Student;
import com.example.term.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;
    public int addTeacher(Teacher teacher){
        return teacherDao.addTeacher(teacher);
    }
    public int updateTeacher(Teacher student){
        return teacherDao.updateTeacher(student);
    }
    public int deleteTeacherById(Integer id){
        return teacherDao.deleteTeacherById(id);
    }
    public Teacher getTeacherById(Integer id){
        return teacherDao.getTeacherById(id);
    }
    public List<Teacher> getAllTeachers(){
        return teacherDao.getAllTeachers();
    }
    public List<Teacher> getTeachersbyKey(String key) {return teacherDao.getTeachersbyKey(key);}
}
