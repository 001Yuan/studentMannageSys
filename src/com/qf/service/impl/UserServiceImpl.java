package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.domain.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userdao=new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.findByNameAndPass(username, password);
	}
	@Override
	public void updatePassword(int id,String newpassword) {
		userdao.updatePassword(id,newpassword);
	}

}
