package com.cssl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {

    private Integer usid;
    private String uname;
    private String upwd;
    private String email;
    private Date borndate;
    private String sex;


    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usid=" + usid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", email='" + email + '\'' +
                ", borndate=" + borndate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
