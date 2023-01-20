package com.example.term.Controller;

import com.example.term.Service.UserService;
import com.example.term.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getuserbykey/{key}")
    public List<User> getuserbyKey(@PathVariable("key") String key){
        return userService.querybyKey(key);
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if(i>0) return "success!";
        else return "error!";
    }
    @PostMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable("username") String username){
        int i = userService.deleteUserbyUsername(username);
        if(i>0) return "success!";
        else return "error!";
    }
    @GetMapping("/addUser")
    public String addUser(@RequestBody User user){
        int i = userService.addUser(user);
        if(i>0) return "success!";
        else return "error!";
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.queryAllUser();
    }
}
