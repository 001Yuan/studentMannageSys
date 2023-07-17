package com.qf.service.impl;

import java.util.List;

import com.qf.dao.StudentDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.domain.PageBean;
import com.qf.domain.Student;
import com.qf.domain.User;
import com.qf.service.StudentService;
/**
 * 业务层
 * @author wgy
 *
 */
public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao=new StudentDaoImpl();
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public List<Student> findBySearch(String sname) {
		// TODO Auto-generated method stub
		return studentDao.findBySearch(sname);
	}

	@Override
	public void add(Student stu) {
		studentDao.add(stu);
		
		
	}

	@Override
	public void update(Student stu) {
		studentDao.update(stu);
		
	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);
		
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNum, int pageSize, String sname) {
		//查询总的数据个数
		long totalCount=studentDao.getCount(sname);
		
		List<Student> data=studentDao.findByPage(pageNum, pageSize, sname);
		
		//创建PageBean
		PageBean pageBean=new PageBean(pageNum, pageSize, totalCount, data);
		
		return pageBean;
	}

}
