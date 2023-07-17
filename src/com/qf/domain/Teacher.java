package com.qf.domain;

import java.io.Serializable;

public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String tname;
	private String tsex;
	private String ttel;
	private String taddress;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTtel() {
		return ttel;
	}
	public void setTtel(String ttel) {
		this.ttel = ttel;
	}
	public String getTaddress() {
		return taddress;
	}
	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	public Teacher(int tid, String tname, String tsex, String ttel, String taddress) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsex = tsex;
		this.ttel = ttel;
		this.taddress = taddress;
	}
	public Teacher() {
		
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tsex=" + tsex + ", ttel=" + ttel + ", taddress="
				+ taddress + "]";
	}
	
	
}
