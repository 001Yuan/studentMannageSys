package com.qf.service.impl;

import java.util.List;

import com.qf.dao.CourseDao;
import com.qf.dao.impl.CourseDaoImpl;
import com.qf.domain.Course;
import com.qf.domain.PageBean;
import com.qf.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
	private CourseDao courseDao= new CourseDaoImpl();

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public List<Course> findBySearch(String coursename) {
		// TODO Auto-generated method stub
		return courseDao.findBySearch(coursename);
	}

	@Override
	public void add(Course course) {
		courseDao.add(course);

	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
	}

	@Override
	public void delete(int id) {
		courseDao.delete(id);

	}

	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return courseDao.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNum, int pageSize, String classname) {
		//查询总的数据个数
				long totalCount=courseDao.getCount(classname);
				
				List<Course> data=courseDao.findByPage(pageNum, pageSize, classname);
				
				//创建PageBean
				PageBean pageBean=new PageBean(pageNum, pageSize, totalCount, data);
				
				return pageBean;
	}

}
