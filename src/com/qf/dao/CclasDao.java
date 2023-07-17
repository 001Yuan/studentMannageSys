package com.qf.dao;

import java.util.List;

import com.qf.domain.Cclas;
import com.qf.domain.Teacher;

public interface CclasDao {
	//获取所有的班级
		public List<Cclas> findAll();
		//根据名称查询
		public List<Cclas> findBySearch(String classname);
		//添加
		public void add(Cclas clas);
		//更新
		public void update(Cclas clas);
		//删除、
		public void delete(int id);
		//根据id查询
		public Cclas findById(int id);
		public  List<Cclas> findAlltname();
		//分页的方法
		public List<Cclas> findByPage(int pageNum,int pageSize,String classname);
		//获取数据个数
		public long getCount(String classname);
		

}
