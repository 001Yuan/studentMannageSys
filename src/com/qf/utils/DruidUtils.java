package com.qf.utils;
/**
 * 数据库连接池工具类
 * @author wgy
 * 1 初始化数据库的参数
 * 2 根据数据库参数创建数据源
 * 3 获取连接池
 * 4 获取连接
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtils {
	//创建数据源对象
	private static DruidDataSource dds;
	//静态代码块,在加载类的执行，而且只执行一次
	static {
		//读取配置文件
		InputStream is=DruidUtils.class.getClassLoader().getResourceAsStream("database.properties");
		//创建一个集合
		Properties properties=new Properties();
		//load方法加载数据
		try {
			properties.load(is);
			
			//初始化dds
			dds=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dds;
	}
	
	public static Connection getConnection() {
		try {
			return dds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
