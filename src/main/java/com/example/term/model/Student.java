package com.example.term.model;

public class Student {
    private Integer id;
    private String Sid;
    private String name;
    private String sex;
    private int age;
    private String college;

    @Override
    public String toString() {
        return "Book{" +
                "sid=" + Sid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age +'\'' +
                ", college'" + college +'\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid(){
        return Sid;
    }

    public void setSid(String Sid){
        this.Sid = Sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}