package com.qf.dao;

import java.util.ArrayList;
import java.util.List;


import com.qf.domain.Teacher;

public interface TeacherDao {
		//获取所有的老师信息
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
		public  List<Teacher> findAlltname();
		//分页的方法
		public List<Teacher> findByPage(int pageNum,int pageSize,String tname);
		//获取数据个数
		public long getCount(String tname);

}
