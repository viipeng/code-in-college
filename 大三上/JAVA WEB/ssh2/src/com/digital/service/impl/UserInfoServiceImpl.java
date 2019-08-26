package com.digital.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digital.dao.UserInfoDao;
import com.digital.entity.UserInfo;
import com.digital.service.UserInfoService;
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	@Override
	public List<UserInfo> login(UserInfo userInfo) {
		return userInfoDao.search(userInfo);
	}
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
