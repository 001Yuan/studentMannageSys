package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.dao.CclasDao;
import com.qf.domain.Cclas;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.utils.DruidUtils;

public class CclasDaoImpl implements CclasDao {

	@Override
	public List<Cclas> findAll() {
		//创建QueryRunner( Connection Statment 数据封装)
				QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
				try {
					//查询
					return qr.query("select * from class", new BeanListHandler<Cclas>(Cclas.class));
				} catch (SQLException e) {
					throw new RuntimeException("查询班级信息失败");
				}
				
	}

	@Override
	public List<Cclas> findBySearch(String classname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		//? 占位符   模糊查询  % 任意多个字符   _一个字符
		try {
			return qr.query("select * from class where cclasname like ? ", new BeanListHandler<Cclas>(Cclas.class),"%"+classname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("根据班级名称查询班级信息失败",e);
		}
	}

	@Override
	public void add(Cclas clas) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		// Object... objs  Object[] objs
		Object[] params= {clas.getClassId(),clas.getCclasname()};
		try {
			qr.update("insert into class(classId,cclasname) values(?,?)",params);
		} catch (SQLException e) {
			throw new RuntimeException("添加班级信息失败",e);
		}
		

	}

	@Override
	public void update(Cclas clas) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {clas.getCclasname(),clas.getTeachername(),clas.getClassId(),};
		try {
			qr.update("update class set cclasname=?,teachername=? where classId=?",params);
		} catch (SQLException e) {
			throw new RuntimeException("更新班级信息失败",e);
		}

	}

	@Override
	public void delete(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("delete from class where classId=?",id);
		} catch (SQLException e) {
			throw new RuntimeException("删除班级信息失败",e);
		}

	}

	@Override
	public Cclas findById(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from class where classId=?",new BeanHandler<Cclas>(Cclas.class),id);
		} catch (SQLException e) {
			throw new RuntimeException("获取班级信息失败",e);
		}
	}

	@Override
	public List<Cclas> findByPage(int pageNum, int pageSize, String cclasname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from class where cclasname like ? limit ?,?",new BeanListHandler<Cclas>(Cclas.class),"%"+cclasname+"%",(pageNum-1)*pageSize,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException("分页获取班级信息失败",e);
		}
	}

	@Override
	public long getCount(String cclasname) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return (Long) qr.query("select count(*) from class where cclasname like ?",new ScalarHandler(),"%"+cclasname+"%");
		} catch (SQLException e) {
			throw new RuntimeException("获取数据个失败",e);
		}
	}
	
	@Override
	public List<Cclas> findAlltname(){
		//创建QueryRunner( Connection Statment 数据封装)
				QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
				try {
					//查询
					return qr.query("select cclasname from class", new BeanListHandler<Cclas>(Cclas.class));
				} catch (SQLException e) {
					throw new RuntimeException("查询班级信息失败");
				}
	}

}
