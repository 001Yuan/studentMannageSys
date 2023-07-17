package com.qf.domain;

import java.io.Serializable;

public class Achievement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int achievementid;
	private int stuid;
	private String coursename;
	private String achievement;
	
	public int getAchievementid() {
		return achievementid;
	}
	public void setAchievementid(int achievementid) {
		this.achievementid = achievementid;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public Achievement() {
	}
	public Achievement(int achievementid, int stuid, String coursename, String achievement) {
		super();
		this.achievementid = achievementid;
		this.stuid = stuid;
		this.coursename = coursename;
		this.achievement = achievement;
	}
	@Override
	public String toString() {
		return "Achievement [achievementid=" + achievementid + ", stuid=" + stuid + ", coursename=" + coursename
				+ ", achievement=" + achievement + "]";
	}
	
	
	
	

}
