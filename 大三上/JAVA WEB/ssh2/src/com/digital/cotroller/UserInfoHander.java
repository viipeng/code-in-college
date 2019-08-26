package com.digital.cotroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digital.entity.UserInfo;
import com.digital.service.UserInfoService;

@RequestMapping("/userinfo")
@Controller
public class UserInfoHander {
	@Autowired
	private UserInfoService  userInfoService;

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	//http://localhost:8080/ssh2/userinfo/login
	@RequestMapping("/login")
	public String login(UserInfo ui){
		List<UserInfo> uList= userInfoService.login(ui);
		if(uList.size()>= 1){
			return "index";
		}else{
			return "redirect:/Login.jsp";
		}
	}
}
