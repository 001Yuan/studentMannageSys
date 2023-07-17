package com.qf.service;

import java.util.List;

import com.qf.domain.Course;
import com.qf.domain.PageBean;

public interface CourseService {
	//获取所有的课程
			public List<Course> findAll();
			//根据课程查询
			public List<Course> findBySearch(String coursename);
			//添加
			public void add(Course course);
			//更新
			public void update(Course course);
			//删除、
			public void delete(int id);
			//根据id查询
			public Course findById(int id);
			
			public PageBean findByPage(int pageNum,int pageSize,String classname);

}
