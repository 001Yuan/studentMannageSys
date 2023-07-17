package com.qf.dao;
/**
 * dao操作
 * Database Access Object
 * @author wgy
 *
 */

import java.util.List;

import com.qf.domain.Student;


public interface StudentDao {
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
	//根据id查询
	public Student findById(int id);
	
	//分页的方法
	public List<Student> findByPage(int pageNum,int pageSize,String sname);
	//获取数据个数
	public long getCount(String sname);
	
}
