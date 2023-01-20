package com.example.term.model;

public class Teacher {
    private Integer id;
    private String name;
    private String position;
    private String sex;
    private int age;
    private String image;
    private String edubackground;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String Position){
        this.position = Position;
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

    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    public String getEdubackground() {
        return edubackground;
    }

    public void setEdubackground(String Edu) {
        this.edubackground = Edu;
    }
}
