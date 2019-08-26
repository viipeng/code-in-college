package com.shw.dao;

public interface UserInfoDAO {

	//数据服务层完成单个表的CRUD
	public boolean login(String name, String pwd);
	
}
