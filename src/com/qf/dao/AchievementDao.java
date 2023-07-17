package com.qf.dao;

import java.util.List;

import com.qf.domain.Achievement;


public interface AchievementDao {
	//获取所有的成绩
			public List<Achievement> findAll();
			//根据姓名查询
			public  List<Achievement> findBySearch(int stuid);
			//添加
			public void add(Achievement achievement);
			//更新
			public void update(Achievement achievement);
//			//删除、
			public void delete(int id);
			//根据id查询
			public Achievement findById(int id);
//			public  List<Achievement> findAlltname();
			//分页的方法
			public List<Achievement> findByPage(int pageNum,int pageSize,String coursename);
			//获取数据个数
			public long getCount(String coursename);
			

}
