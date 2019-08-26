package com.shw.service.impl;

import com.shw.dao.UserInfoDAO;
import com.shw.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDAO userInfoDAO;
	
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	@Override
	public boolean login(String name, String pwd) {
		//登录名字是否非法，将密码进行加密
		return userInfoDAO.login(name, pwd);
	}

}
