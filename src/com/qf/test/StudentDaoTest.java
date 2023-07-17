package com.qf.test;

import java.util.List;

import org.junit.Test;

import com.qf.dao.StudentDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.domain.Student;

/**
 * 测试studentdao
 * @author wgy
 *
 */
public class StudentDaoTest {
	/**
	 * 查询方法
	 */
	@Test
	public void testFindAll() {
		StudentDao studentDao=new StudentDaoImpl();
		List<Student> stuLists = studentDao.findAll();
		for (Student student : stuLists) {
			System.out.println(student.toString());
		}
	}
	@Test
	public void testFindBySearch() {
		StudentDao studentDao=new StudentDaoImpl();
		List<Student> stuList=studentDao.findBySearch("北");
		for (Student student : stuList) {
			System.out.println(student.toString());
		}
	}
//	@Test
//	public void testAdd() {
//		StudentDao studentDao=new StudentDaoImpl();
//		studentDao.add(new Student(0, "王振兴", 20,"男", "计算机","13838383838", "河北石家庄xxxx"));
//	}
//	@Test
//	public void testUpdate() {
//		StudentDao studentDao=new StudentDaoImpl();
//		studentDao.update(new Student(13, "王振兴", 22,"女", "计算机","16868686868", "河北高老庄xxxx"));
//	}
	@Test
	public void testDelete() {
		StudentDao studentDao=new StudentDaoImpl();
		studentDao.delete(13);
	}
	@Test
	public void testGetCount() {
		StudentDao studentDao=new StudentDaoImpl();
		System.out.println(studentDao.getCount(""));
	}
	
}
