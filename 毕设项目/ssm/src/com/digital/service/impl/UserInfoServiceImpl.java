package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.UserInfoDAO;
import com.digital.pojo.UserInfo;
import com.digital.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
    @Autowired
	private UserInfoDAO userInfoDao;

    @Override
    public void haveRefund(UserInfo ui){
    	userInfoDao.haveRefund(ui);
    }
    
    @Override
    public void havePaid(UserInfo ui){
    	userInfoDao.havePaid(ui);
    }
    
    @Override
    public float getAccount_balanceByUid(int uid)
    {
		return userInfoDao.getAccount_balanceByUid(uid);	
    }
    
    @Override
	public UserInfo getUserByCode(UserInfo ui) {
    	//通过userInfoDao查询数据库
		return userInfoDao.getUserInfoByCode(ui);
	}

    @Override
    public UserInfo getUserInfoByUN(UserInfo ui)
    {
		return userInfoDao.getUserInfoByUN(ui);	
    }
    
	@Override
	public UserInfo getUserInfoByUid(int uid) {
		return userInfoDao.getUserInfoByUid(uid);
	}
	
	@Override
	public float queryAccount(int uid) {
		return userInfoDao.queryAccount(uid);
	}

	@Override
	public void changePassword(UserInfo ui) {
		userInfoDao.changePassword(ui);
	}

	@Override
    public String getPasswordByUid(int uid){
		return userInfoDao.getPasswordByUid(uid);
    }

	@Override
    public String getNameByUid(int uid){
		return userInfoDao.getNameByUid(uid);
    }

	@Override
	public void addmoney(UserInfo ui) {
		userInfoDao.addmoney(ui);
	}

    //以下是后台的5个方法
	@Override
	public List<UserInfo> getWhollyUserInfoByUid(int uid) {
		return userInfoDao.getWhollyUserInfoByUid(uid);
	}

	@Override
	public List<UserInfo> getUserInfo() {
		return userInfoDao.getUserInfo();
	}

	@Override
	public void addUser(UserInfo ui){
		userInfoDao.addUser(ui);
	}

	@Override
	public void deleteUserInfo(int uid) {
		userInfoDao.deleteUserInfo(uid);
	}

	@Override
	public void updateUserInfo(UserInfo ui) {
		userInfoDao.updateUserInfo(ui);
	}

}
