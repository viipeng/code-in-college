package com.shw.dao.impl;

import com.shw.dao.UserInfoDAO;

public class UserInfoDaoImpl implements UserInfoDAO {

	@Override
	public boolean login(String name, String pwd){
		if(name.equals("admin") && pwd.equals("123456")){
			return true;
		}
		return false;
	}

}
