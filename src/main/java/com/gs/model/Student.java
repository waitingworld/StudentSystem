package com.gs.model;

import java.util.Date;

public class Student {
    private String id;
    private String code;
    private String name;
    private int sex;
    private String class_id;
    private int use_flag;
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public int getUse_flag() {
        return use_flag;
    }

    public void setUse_flag(int use_flag) {
        this.use_flag = use_flag;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", class_id='" + class_id + '\'' +
                ", use_flag=" + use_flag +
                ", birthday=" + birthday +
                '}';
    }
}
