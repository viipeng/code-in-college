package com.digital.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.digital.entity.UserInfo;
import com.digital.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{
	private UserInfo ui;
	Map<String, Object> session;
	private UserInfoService userInfoService ;
	public String doLogin(){
		List<UserInfo> uiList=userInfoService.login(ui);
		if(uiList.size()>=1){
			session.put("CURRENT_USER", uiList.get(0));
			return "index";
		}else{
			return "login";
		}
		
	}
	
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
