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
		//��¼�����Ƿ�Ƿ�����������м���
		return userInfoDAO.login(name, pwd);
	}

}
