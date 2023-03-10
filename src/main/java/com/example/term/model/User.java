package com.example.term.model;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String date;

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}
}
