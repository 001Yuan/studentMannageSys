package com.qf.service;

import java.util.List;

import com.qf.domain.Cclas;
import com.qf.domain.PageBean;


public interface CclasService {
	//获取所有的班级信息
			public List<Cclas> findAll();
			//根据名称查询
			public List<Cclas> findBySearch(String classname);
			//添加
			public void add(Cclas clas);
			//更新
			public void update(Cclas clas);
			//删除、
			public void delete(int id);
			//根据id查询班级
			public Cclas findById(int id);
			//分页的功能
			public PageBean findByPage(int pageNum,int pageSize,String classname);
			
			public  List<Cclas> findAlltname();

}
