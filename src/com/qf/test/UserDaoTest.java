package com.qf.test;

import org.junit.Test;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.domain.User;

public class UserDaoTest {
	@Test
	public void testFind() {
		UserDao userdao=new UserDaoImpl();
		User user=userdao.findByNameAndPass("admin", "112818");
		if(user!=null) {
			System.out.println("登录成功");
		}else {
			System.out.println("123");
		}
	}
}
