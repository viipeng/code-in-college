package com.digital.service;

import java.util.List;

import com.digital.pojo.MerchantInfo;
import com.digital.pojo.UserInfo;

public interface UserInfoService {

	public void haveRefund(UserInfo ui);
	
	public void havePaid(UserInfo ui);
	
    public float getAccount_balanceByUid(int uid);
    
    public UserInfo getUserByCode(UserInfo ui);
    
    public UserInfo getUserInfoByUN(UserInfo ui);
    
//    public int getUidByUname(int uid);
        
//    public void addUser(UserInfo ui);
    
    public UserInfo getUserInfoByUid(int uid);

    public float queryAccount(int uid);

    public void changePassword(UserInfo ui);

    public String getPasswordByUid(int uid);

    public String getNameByUid(int uid);

    public void addmoney(UserInfo ui);

    //以下是后台的5个方法,有些前台也用到了
  	public List<UserInfo> getWhollyUserInfoByUid(int uid);
  	
  	public List<UserInfo> getUserInfo();
  	
  	public void addUser(UserInfo ui);
  	
  	public void deleteUserInfo(int uid);
  	
  	public void updateUserInfo(UserInfo ui);
}
