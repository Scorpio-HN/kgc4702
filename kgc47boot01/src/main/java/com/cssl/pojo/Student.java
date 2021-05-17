package com.cssl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student implements Serializable{
	private Integer sid;
	private String sname;
	@JsonFormat(pattern = "yyyy-MM-dd")
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
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", borndate=" + borndate + "]";
	}
	public Student(Integer sid, String sname, Date borndate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.borndate = borndate;
	}
	public Student() {
		super();
	}
	public Student(String sname, Date borndate) {
		super();
		this.sname = sname;
		this.borndate = borndate;
	}
	
	
	
	

}
