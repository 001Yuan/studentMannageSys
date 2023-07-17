package com.qf.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qf.dao.UserDao;
import com.qf.domain.User;
import com.qf.utils.DruidUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User findByNameAndPass(String username, String password) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			return qr.query("select * from user where username=? and password=?",new BeanHandler<>(User.class),username,password);
		} catch (SQLException e) {
			throw new RuntimeException("根据用户和密码查询失败");
		}
	}

	@Override
	public void updatePassword(int id,String newpassword) {
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		try {
			qr.update("update user set password=? where id=?",newpassword,id);
		} catch (SQLException e) {
			throw new RuntimeException("密码更新失败");
		}
		
	}

}
