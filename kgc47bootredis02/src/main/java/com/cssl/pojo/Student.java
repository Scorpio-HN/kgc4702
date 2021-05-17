package com.cssl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student /*implements Serializable */{

    private Integer sid;
    private String sname;
    private Date borndate;

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

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }
}
