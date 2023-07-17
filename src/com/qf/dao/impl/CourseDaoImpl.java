package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.dao.CourseDao;
import com.qf.domain.Course;
import com.qf.domain.Student;
import com.qf.utils.DruidUtils;

public class CourseDaoImpl implements CourseDao {

	@Override
	public List<Course> findAll() {
		//创建QueryRunner( Connection Statment 数据封装)
				QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
				try {
					//查询
					return qr.query("select * from course", new BeanListHandler<Course>(Course.class));
				} catch (SQLException e) {
					throw new RuntimeException("查询课程信息失败");
				}
	}

	@Override
	public List<Course> findBySearch(String coursename) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		//? 占位符   模糊查询  % 任意多个字符   _一个字符
		try {
			return qr.query("select * from course where coursename like ? ", new BeanListHandler<Course>(Course.class),"%"+coursename+"%");
		} catch (SQLException e) {
			throw new RuntimeException("根据名称查询课程信息失败",e);
		}
	}

	@Override
	public void add(Course course) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		// Object... objs  Object[] objs
		Object[] params= {course.getCourseId(),course.getCoursename(),course.getCoursetype(),course.getClassname()};
		try {
			qr.update("insert into course(courseId,coursename,coursetype,classname) values(?,?,?,?)",params);
		} catch (SQLException e) {
			throw new RuntimeException("添加课程信息失败",e);
		}

	}

	@Override
	public void update(Course course) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {course.getCoursename(),course.getCoursetype(),course.getClassname(),course.getCourseId()};
		try {
			qr.update("update course set coursename=?,coursetype=?,classname=? where courseId=?",params);
		} catch (SQLException e) {
			throw new RuntimeException("更新课程信息失败",e);
		}

	}

	@Override
	public void delete(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("delete from course where courseId=?",id);
		} catch (SQLException e) {
			throw new RuntimeException("删除课程信息失败",e);
		}

	}

	@Override
	public Course findById(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from course where courseId=?",new BeanHandler<Course>(Course.class),id);
		} catch (SQLException e) {
			throw new RuntimeException("获取课程信息失败",e);
		}
	}

	@Override
	public List<Course> findByPage(int pageNum, int pageSize, String coursename) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from course where coursename like ? limit ?,?",new BeanListHandler<Course>(Course.class),"%"+coursename+"%",(pageNum-1)*pageSize,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException("分页获取课程信息失败",e);
		}
	}

	@Override
	public long getCount(String coursename) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return (Long) qr.query("select count(*) from course where coursename like ?",new ScalarHandler(),"%"+coursename+"%");
		} catch (SQLException e) {
			throw new RuntimeException("获取数据个失败",e);
		}
	}

}
