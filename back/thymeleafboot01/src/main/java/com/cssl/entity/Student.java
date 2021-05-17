package com.cssl.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
//@Data
//@Setter
//@Getter
//@AllArgsConstructor()
//@NoArgsConstructor
//@ToString
public class Student implements Serializable {

    private int sid;
    private String sname;
    private Date bornDate;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Student() {
    }

    public Student(int sid, String sname, Date bornDate) {
        this.sid = sid;
        this.sname = sname;
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}
