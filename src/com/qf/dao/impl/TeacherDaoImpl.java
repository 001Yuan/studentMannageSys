package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.Connection;
import com.qf.dao.TeacherDao;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.utils.DruidUtils;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public List<Teacher> findAll() {
		//创建QueryRunner( Connection Statment 数据封装)
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			//查询
			return qr.query("select * from teacher", new BeanListHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			throw new RuntimeException("查询老师信息失败");
		}
	}

	@Override
	public List<Teacher> findBySearch(String tname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		//? 占位符   模糊查询  % 任意多个字符   _一个字符
		try {
			return qr.query("select * from teacher where tname like ? ", new BeanListHandler<Teacher>(Teacher.class),"%"+tname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("根据姓名查询老师信息失败",e);
		}
	
	}

	@Override
	public void add(Teacher teh) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		// Object... objs  Object[] objs
		Object[] params= {teh.getTid(),teh.getTname(),teh.getTsex(),teh.getTtel(),teh.getTaddress()};
		try {
			qr.update("insert into teacher(tid,tname,tsex,ttel,taddress) values(?,?,?,?,?)",params);
		} catch (SQLException e) {
			throw new RuntimeException("添加老师信息失败",e);
		}
		
	}

	@Override
	public void update(Teacher teh) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {teh.getTname(),teh.getTsex(),teh.getTtel(),teh.getTaddress(),teh.getTid()};
		try {
			qr.update("update teacher set tname=?,tsex=?,ttel=?,taddress=? where tid=?",params);
		} catch (SQLException e) {
			throw new RuntimeException("更新老师信息失败",e);
		}

	}

	@Override
	public void delete(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("delete from teacher where tid=?",id);
		} catch (SQLException e) {
			throw new RuntimeException("删除老师信息失败",e);
		}
		
	}

	@Override
	public Teacher findById(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from teacher where tid=?",new BeanHandler<Teacher>(Teacher.class),id);
		} catch (SQLException e) {
			throw new RuntimeException("获取老师信息失败",e);
		}
	}

	@Override
	public List<Teacher> findByPage(int pageNum, int pageSize, String tname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from teacher where tname like ? limit ?,?",new BeanListHandler<Teacher>(Teacher.class),"%"+tname+"%",(pageNum-1)*pageSize,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException("分页获取老师信息失败",e);
		}
	}

	@Override
	public long getCount(String tname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return (Long) qr.query("select count(*) from teacher where tname like ?",new ScalarHandler(),"%"+tname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("获取数据个失败",e);
		}
	}
	
	@Override
	public List<Teacher> findAlltname(){
		//创建QueryRunner( Connection Statment 数据封装)
				QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
				try {
					//查询
					return qr.query("select tname from teacher", new BeanListHandler<Teacher>(Teacher.class));
				} catch (SQLException e) {
					throw new RuntimeException("查询老师信息失败");
				}
	}

}
