package com.qf.domain;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;
	private int sage;
	private String ssex;
	private String sdept;
	private String stel;
	private String sclas;
	private String saddress;
	
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
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	
	public String getSclas() {
		return sclas;
	}
	public void setSclas(String sclas) {
		this.sclas = sclas;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sname, int sage, String ssex, String sdept,String sclas, String stel, String saddress) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.sdept = sdept;
		this.sclas = sclas;
		this.stel = stel;
		this.saddress = saddress;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", ssex=" + ssex + ", sdept=" + sdept
				+ ", stel=" + stel + ", sclas=" + sclas + ", saddress=" + saddress + "]";
	}
	
	
	
	
	
}
