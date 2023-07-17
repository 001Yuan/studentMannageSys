package com.qf.domain;

import java.io.Serializable;

public class Cclas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int classId;
	private String cclasname;
	private String teachername;    //班主任字段
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getCclasname() {
		return cclasname;
	}
	public void setCclasname(String cclasname) {
		this.cclasname = cclasname;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public Cclas(int classId, String cclasname, String teachername) {
		super();
		this.classId = classId;
		this.cclasname = cclasname;
		this.teachername = teachername;
	}
	public Cclas() {
	
	}
	@Override
	public String toString() {
		return "Cclas [classId=" + classId + ", cclasname=" + cclasname + ", teachername=" + teachername + "]";
	}
	
	
	

}
