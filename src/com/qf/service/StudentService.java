package com.qf.service;

import java.util.List;

import com.qf.domain.PageBean;
import com.qf.domain.Student;
import com.qf.domain.User;

public interface StudentService {
	//获取所有的学生信息
		public List<Student> findAll();
		//根据姓名查询
		public List<Student> findBySearch(String sname);
		//添加
		public void add(Student stu);
		//更新
		public void update(Student stu);
		//删除、
		public void delete(int id);
		//根据id查询学生
		public Student findById(int id);
		//分页的功能
		public PageBean findByPage(int pageNum,int pageSize,String sname);
}
