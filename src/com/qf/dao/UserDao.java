package com.qf.dao;

import com.qf.domain.User;

public interface UserDao {
	public User findByNameAndPass(String username,String password);

	public void updatePassword(int id,String newpassword);
}
