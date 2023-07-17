package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.dao.AchievementDao;
import com.qf.domain.Achievement;
import com.qf.domain.Cclas;
import com.qf.utils.DruidUtils;

public class AchievementDaoImpl implements AchievementDao {

	@Override
	public List<Achievement> findAll() {
		//创建QueryRunner( Connection Statment 数据封装)
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			//查询
			return qr.query("select * from achievement", new BeanListHandler<Achievement>(Achievement.class));
		} catch (SQLException e) {
			throw new RuntimeException("查询成绩信息失败");
		}
	}

	@Override
	public List<Achievement> findBySearch(int stuid) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from achievement where stuid=?",new BeanListHandler<Achievement>(Achievement.class),stuid);
		} catch (SQLException e) {
			throw new RuntimeException("获取学生成绩失败",e);
		}
	}

	@Override
	public void add(Achievement achievement) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		// Object... objs  Object[] objs
		Object[] params= {achievement.getAchievementid(),achievement.getStuid(),achievement.getCoursename(),achievement.getAchievement()};
		try {
			qr.update("insert into achievement(achievementid,stuid,coursename,achievement) values(?,?,?,?)",params);
		} catch (SQLException e) {
			throw new RuntimeException("添加学生成绩失败",e);
		}
		


	}

	@Override
	public void update(Achievement achievement) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {achievement.getCoursename(),achievement.getAchievement(),achievement.getAchievementid()};
		try {
			qr.update("update achievement set coursename=?,achievement=? where achievementid=?",params);
		} catch (SQLException e) {
			throw new RuntimeException("更新成绩信息失败",e);
		}
	}

	@Override
	public void delete(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("delete from achievement where achievementid=?",id);
		} catch (SQLException e) {
			throw new RuntimeException("删除课程成绩信息失败",e);
		}

	}

	@Override
	public Achievement findById(int id) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from achievement where achievementid=?",new BeanHandler<Achievement>(Achievement.class),id);
		} catch (SQLException e) {
			throw new RuntimeException("获取成绩信息失败",e);
		}
	}

//	@Override
//	public List<Achievement> findAlltname(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Achievement> findByPage(int pageNum, int pageSize, String coursename) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from achievement where coursename like ? limit ?,?",new BeanListHandler<Achievement>(Achievement.class),"%"+coursename+"%",(pageNum-1)*pageSize,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException("分页获取成绩信息失败",e);
		}
	}

	@Override
	public long getCount(String coursename) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return (Long) qr.query("select count(*) from achievement where coursename like ?",new ScalarHandler(),"%"+coursename+"%");
		} catch (SQLException e) {
			throw new RuntimeException("获取数据个失败",e);
		}
	}


}
