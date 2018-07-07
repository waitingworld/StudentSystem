package com.gs.model;

import java.util.Date;

public class Discipline {
    private String id;
    private String code;
    private String profession_nameid;
    private String name;
    private String type;
    private Date open_time;
    private int period;//学时
    private int credit;//学分

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

    public String getProfession_nameid() {
        return profession_nameid;
    }

    public void setProfession_nameid(String profession_nameid) {
        this.profession_nameid = profession_nameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Date open_time) {
        this.open_time = open_time;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", profession_nameid='" + profession_nameid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", open_time=" + open_time +
                ", period=" + period +
                ", credit=" + credit +
                '}';
    }
}
