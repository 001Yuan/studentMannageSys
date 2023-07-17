package com.qf.service;

import com.qf.domain.User;

public interface UserService {
	public User login(String username,String password);

	public void updatePassword(int id,String newpassword);
}
