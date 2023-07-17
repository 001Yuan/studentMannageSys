package com.qf.test;

import java.sql.Connection;

import org.junit.Test;

import com.qf.utils.DruidUtils;

public class DbTest {

	@Test
	public void testConnection() {
		Connection connection=DruidUtils.getConnection();
		if(connection!=null) {
			System.out.println("连接成功");
		}else {
			System.out.println("失败");
		}
	}
}
