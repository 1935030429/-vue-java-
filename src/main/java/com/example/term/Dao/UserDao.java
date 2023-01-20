package com.example.term.Dao;

import com.example.term.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addUser(User user){
        return jdbcTemplate.update("insert into user(username,password) values(?,?)",user.getUsername(),user.getPassword());
    }
    public int updateUser(User user){
        return jdbcTemplate.update("update user set username=?,password=? where id=?",user.getUsername(),user.getPassword());
    }
    public int deleteUserbyUsername(String username){
        return jdbcTemplate.update("delete from user where username=?",username);
    }
    public List<User> getUserbyKey(String key){
        return jdbcTemplate.query("select * from user where username like '%"+key+"%'",new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getAllUser(){
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }
}
