package com.example.term.Service;

import com.example.term.Dao.UserDao;
import com.example.term.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public int addUser(User user){return userDao.addUser(user);}
    public int updateUser(User user){return userDao.updateUser(user);}
    public int deleteUserbyUsername(String username){return userDao.deleteUserbyUsername(username);}
    public List<User> querybyKey(String key){return userDao.getUserbyKey(key);}
    public List<User> queryAllUser(){return userDao.getAllUser();}
}
