package com.qf.domain;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseId;
	private String coursename;
	private int coursetype;
	private String classname;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(int coursetype) {
		this.coursetype = coursetype;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Course(int courseId, String coursename, int coursetype, String classname) {
		super();
		this.courseId = courseId;
		this.coursename = coursename;
		this.coursetype = coursetype;
		this.classname = classname;
	}
	public Course() {
		
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", coursename=" + coursename + ", coursetype=" + coursetype
				+ ", classname=" + classname + "]";
	}
	
	
	

}
