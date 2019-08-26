package com.digital.dao;

import java.util.List;

import com.digital.entity.UserInfo;

public interface UserInfoDao {

	public List<UserInfo> search(UserInfo userInfo);
}
