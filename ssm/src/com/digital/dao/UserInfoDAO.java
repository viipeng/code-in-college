package com.digital.dao;

import java.util.List;

import com.digital.pojo.UserInfo;

public interface UserInfoDAO {

	public void haveRefund(UserInfo ui);
	
	public void havePaid(UserInfo ui);
	
	public float getAccount_balanceByUid(int uid);

	public UserInfo getUserInfoByCode(UserInfo ui);

	public UserInfo getUserInfoByUN(UserInfo ui);
	
	public UserInfo getUserInfoByUid(int uid);

    public float queryAccount(int uid);

    public void changePassword(UserInfo ui);

    public String getPasswordByUid(int uid);

    public String getNameByUid(int uid);

    public void addmoney(UserInfo ui);

	//以下是后台的5个方法
	public List<UserInfo> getWhollyUserInfoByUid(int uid);
	
	public List<UserInfo> getUserInfo();
	
	public void addUser(UserInfo ui);
	
	public void deleteUserInfo(int uid);
	
	public void updateUserInfo(UserInfo ui);
}
