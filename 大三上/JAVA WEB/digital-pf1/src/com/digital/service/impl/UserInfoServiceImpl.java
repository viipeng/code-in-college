package com.digital.service.impl;

import java.util.List;

import com.digital.dao.UserInfoDAO;
import com.digital.entity.UserInfo;
import com.digital.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO userInfoDAO;
	

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}


	@Override
	public List<UserInfo> login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDAO.search(userInfo);
	}

}
