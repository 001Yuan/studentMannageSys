package com.qf.service;

import java.util.List;

import com.qf.domain.Achievement;
import com.qf.domain.PageBean;

public interface AchievementService {
	
	//获取所有的成绩
	public List<Achievement> findAll();
	//根据学号查询
	public List<Achievement> findBySearch(int stuid);
	//添加
	public void add(Achievement achievement);
	//更新
	public void update(Achievement achievement);
//	//删除、
	public void delete(int id);
	//根据id查询
	public Achievement findById(int id);
//	public  List<Achievement> findAlltname();
	//分页的功能
	public PageBean findByPage(int pageNum,int pageSize,String coursename);

}
