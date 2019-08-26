package com.digital.action;

import com.digital.dao.UserDao;


import com.digital.dao.impl.UserDaoImpl;
import com.digital.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String register() throws Exception {
		String back = "";
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser(user);
		if (result > 0) {
			back = this.SUCCESS;
		} else {
			back = this.INPUT;
		}
		return back;
	}
}
