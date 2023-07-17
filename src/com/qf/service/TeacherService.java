package com.qf.service;

import java.util.ArrayList;
import java.util.List;

import com.qf.domain.PageBean;
import com.qf.domain.Teacher;

public interface TeacherService {
	//获取所有的学生信息
	public List<Teacher> findAll();
	//根据姓名查询
	public List<Teacher> findBySearch(String tname);
	//添加
	public void add(Teacher teh);
	//更新
	public void update(Teacher teh);
	//删除、
	public void delete(int id);
	//根据id查询
	public Teacher findById(int id);
	//分页的功能
	public PageBean findByPage(int pageNum,int pageSize,String tname);
	
	public  List<Teacher> findAlltname();

}
