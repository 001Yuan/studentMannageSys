package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.dao.StudentDao;
import com.qf.domain.Student;
import com.qf.domain.User;
import com.qf.utils.DruidUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> findAll() {
		//创建QueryRunner( Connection Statment 数据封装)
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			//查询
			return qr.query("select * from student", new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			throw new RuntimeException("查询学生信息失败");
		}
		
	}

	@Override
	public List<Student> findBySearch(String sname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		//? 占位符   模糊查询  % 任意多个字符   _一个字符
		try {
			return qr.query("select * from student where sname like ? ", new BeanListHandler<Student>(Student.class),"%"+sname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("根据姓名查询学生信息失败",e);
		}
	
	}

	@Override
	public void add(Student stu) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		// Object... objs  Object[] objs
		Object[] params= {stu.getSid(),stu.getSname(),stu.getSage(),stu.getSsex(),stu.getSdept(),stu.getStel(),stu.getSaddress()};
		try {
			qr.update("insert into student(sid,sname,sage,ssex,sdept,stel,saddress) values(?,?,?,?,?,?,?)",params);
		} catch (SQLException e) {
			throw new RuntimeException("添加学生信息失败",e);
		}
		
		
		
	}

	@Override
	public void update(Student stu) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {stu.getSname(),stu.getSage(),stu.getSsex(),stu.getSdept(),stu.getSclas(),stu.getStel(),stu.getSaddress(),stu.getSid()};
		try {
			qr.update("update student set sname=?,sage=?,ssex=?,sdept=?,sclas=?,stel=?,saddress=? where sid=?",params);
		} catch (SQLException e) {
			throw new RuntimeException("更新学生信息失败",e);
		}
		
		
	}

	@Override
	public void delete(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("delete from student where sid=?",id);
		} catch (SQLException e) {
			throw new RuntimeException("删除学生信息失败",e);
		}
		
	}

	@Override
	public Student findById(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from student where sid=?",new BeanHandler<Student>(Student.class),id);
		} catch (SQLException e) {
			throw new RuntimeException("获取学生信息失败",e);
		}
		
	}

	@Override
	public List<Student> findByPage(int pageNum, int pageSize, String sname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from student where sname like ? limit ?,?",new BeanListHandler<Student>(Student.class),"%"+sname+"%",(pageNum-1)*pageSize,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException("分页获取学生信息失败",e);
		}
	}

	@Override
	public long getCount(String sname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return (Long) qr.query("select count(*) from student where sname like ?",new ScalarHandler(),"%"+sname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("获取数据个失败",e);
		}
	}

}
