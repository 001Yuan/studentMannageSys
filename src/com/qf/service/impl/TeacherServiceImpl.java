package com.qf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qf.dao.TeacherDao;
import com.qf.dao.impl.TeacherDaoImpl;
import com.qf.domain.PageBean;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDao teacherDao = new TeacherDaoImpl();

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherDao.findAll();
	}

	@Override
	public List<Teacher> findBySearch(String tname) {
		// TODO Auto-generated method stub
		return teacherDao.findBySearch(tname);
	}

	@Override
	public void add(Teacher teh) {
		// TODO Auto-generated method stub
		teacherDao.add(teh);

	}

	@Override
	public void update(Teacher teh) {
		// TODO Auto-generated method stub
		teacherDao.update(teh);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		teacherDao.delete(id);

	}

	@Override
	public Teacher findById(int id) {
		// TODO Auto-generated method stub
		return teacherDao.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNum, int pageSize, String tname) {
		//查询总的数据个数
		long totalCount=teacherDao.getCount(tname);
				
		List<Teacher> data1=teacherDao.findByPage(pageNum, pageSize, tname);
				
		//创建PageBean
		PageBean pageBean1=new PageBean(pageNum, pageSize, totalCount, data1);
				
		return pageBean1;
	}
	
	public  List<Teacher> findAlltname(){
		return teacherDao.findAlltname();
	};

}
