package com.cssl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student /*implements Serializable */{

    private Integer sid;
    private String sname;
    private Date birthDay;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Student() {
    }

    public Student(Integer sid, String sname, Date birthDay) {
        this.sid = sid;
        this.sname = sname;
        this.birthDay = birthDay;
    }
}
