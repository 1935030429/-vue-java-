package com.example.term.Service;

import com.example.term.Dao.StudentDao;
import com.example.term.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public int addStudent(Student student){
        return studentDao.addStudent(student);
    }
    public int updateStudent(Student student){
        return studentDao.update(student);
    }
    public int deleteStudentById(Integer id){
        return studentDao.deleteStudentById(id);
    }
    public Student getStudentById(Integer id){
        return studentDao.getStudentById(id);
    }
    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
}
