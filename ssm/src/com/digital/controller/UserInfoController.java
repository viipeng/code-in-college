package com.digital.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.AddMoney;
import com.digital.pojo.MerchantInfo;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.UserInfo;
import com.digital.service.AddMoneyService;
import com.digital.service.UserInfoService;

@RequestMapping("/userInfo") 
@Controller//标识是一个控制器
public class UserInfoController {
	
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
	private AddMoneyService addMoneyService;
	
	// http://localhost:8080/ssm/  userInfo/login
	@RequestMapping("/login") 
	public ModelAndView login(UserInfo ui, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		UserInfo us=userInfoService.getUserByCode(ui);
		if(us!=null && us.getUsername()!=null){
//			List<MeauInfoAdd> miaList= meauInfoAddService.getMeauInfoAdd();
			String url = (String) session.getAttribute("previousUrl");//登陆的验证通过后,在从session里获取前画面的url
			//这么做是因为如果用户刚退出登录就再次登录会导致登录成功后返回到退出登录的页面，执行HomeController中的logout方法，退出了登录状态
			if(url.compareTo("http://localhost:8080/ssm/home/login")==0
					||url.compareTo("http://localhost:8080/ssm/home/register")==0
					||url.compareTo("http://localhost:8080/ssm/restaurantInfo/searchFood")==0
					||url.compareTo("http://localhost:8080/ssm/home/searchRestaurant")==0
					||url.compareTo("http://localhost:8080/ssm/home/merchantLogin")==0)
//				url="http://pc-201801011112:8080/ssm/home/visit";//把这个if注释掉是因为会有很多的问题
				mav.setViewName("redirect:../home/visit");
			else
				mav.setViewName("redirect:"+url);
			/*UserInfo user= userInfoService.getUserInfoByUid(us.getUid());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("usex", user.getUsex());
			session.setAttribute("account_balance", user.getAccount_balance());*/
//			System.out.println("用户的信息为："+session.getAttribute("username")+session.getAttribute("usex")+session.getAttribute("account_balance"));
			session.setAttribute("uid",us.getUid());
//			mav.setViewName("redirect:../home/visit");
//			mav.setViewName("jsp/homepage");
//			mav.addObject("miaList", miaList);
//			mav.addObject("uid", session.getAttribute("uid"));
			
			
			return mav;
		}
		else{
			mav.setViewName("redirect:../home/login");
			return mav;
		}
	}
	
	@RequestMapping("/register") 
	public ModelAndView register(UserInfo ui, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		UserInfo us=userInfoService.getUserInfoByUN(ui);
		if(ui.getUsername()!=null && us==null){//防止页面传递空数据过来
			userInfoService.addUser(ui);
			mav.setViewName("redirect:../home/login");
			return mav;
//			return "jsp/login";
		}
		else{
			mav.setViewName("redirect:../home/register");
//			session.setAttribute("userExist", "1");//用来记录注册的用户是否已经注册过了
//			mav.addObject(session.getAttribute("userExist"));
			//提示用户该账号已经注册过了
			JOptionPane.showMessageDialog(null, "该用户已经注册！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return mav;
//			return "jsp/register";
		}
	}
	
	/*@RequestMapping(value="/getUIInHead", method= RequestMethod.GET) 
	@RequestMapping("/getUIInHead")
	public ModelAndView getUIInHead(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		int uid= (Integer) session.getAttribute("uid");
		UserInfo user=userInfoService.getUserInfoByUid(uid);
		try {
			response.getWriter().println(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@RequestMapping("/query") 
	public ModelAndView query(int uid)
	{
		ModelAndView mav = new ModelAndView();
		UserInfo ui=userInfoService.getUserInfoByUid(uid);
		mav.setViewName("jsp/personalInformation");
		mav.addObject("uid", ui.getUid());
		mav.addObject("ui", ui);
		return mav;
	}

	@RequestMapping("/jumpToAddMoney") 
	public ModelAndView jumpToAddMoney()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/addMoney");
		return mav;
	}

	@RequestMapping("/addMoney") 
	public ModelAndView addMoney(int money, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if( session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			//新建一个AddMoney类
			AddMoney am= new AddMoney();
			am.setId(uid);
			am.setMoney(money);
			am.setState(0);
			am.setStatus("user");
			String name= userInfoService.getNameByUid(uid);
			am.setName(name);
			Date date= new Date();
			String adate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
			am.setAdate(adate);
			addMoneyService.creatPetition(am);
		}
		mav.setViewName("redirect:../home/visit");
		return mav;
	}
	
	//后台
	@RequestMapping("/selectByUid") 
	public ModelAndView selectByUid(String uid1){
		int uid=0;
		if(uid1.length()!=0){
			uid= Integer.valueOf(uid1).intValue();	
		}
		List<UserInfo> ui = userInfoService.getWhollyUserInfoByUid(uid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/user-list");
		mav.addObject("uiList", ui);
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(){
		List<UserInfo> uiList = userInfoService.getUserInfo();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/user-list");
		mav.addObject("uiList", uiList);
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/user-add");
		return mav;
	}
	
	@RequestMapping("/addUser") 
	public ModelAndView addUser(UserInfo ui){
		userInfoService.addUser(ui);//addDelivererInfo(di);
//		System.out.println("要添加的用户是"+ ui);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../userInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int uid){
		List<UserInfo> ui = userInfoService.getWhollyUserInfoByUid(uid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/user-upd");
		mav.addObject("uiList", ui);
		return mav;
	}

	@RequestMapping("/updateUser") 
	public ModelAndView updateUser(UserInfo ui){
		userInfoService.updateUserInfo(ui);//updateDelivererInfo(di);
		System.out.println("要修改的用户是"+ ui);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../userInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteUser") 
	public ModelAndView deleteUser(int uid){
		userInfoService.deleteUserInfo(uid);//deleteDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../userInfo/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyUser")
	public ModelAndView deleteManyUser(String str){
		int uid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				uid= Integer.valueOf(temp).intValue();
				userInfoService.deleteUserInfo(uid);//deleteDelivererInfoByDid(did);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../userInfo/selectAll");
		return mav;
	}

	@RequestMapping(value="/queryAccount", method= RequestMethod.GET)  
	@ResponseBody
	public String queryAccount(HttpServletRequest request, HttpServletResponse response)
	{
	    HttpSession session = request.getSession();
	    float account=0;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			account= userInfoService.queryAccount(uid);
		}
		return String.valueOf(account);
	}

	@RequestMapping("/jumpToChangePassword") 
	public ModelAndView jumpToChangePassword(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/changePassword");
		return mav;
	}

	@RequestMapping("/changePassword") 
	public ModelAndView changePassword(HttpSession session, String password)
	{
		ModelAndView mav = new ModelAndView();
		UserInfo ui = new UserInfo();
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			ui.setUid(uid);
			ui.setPassword(password);
			userInfoService.changePassword(ui);
			mav.setViewName("redirect:../home/visit");
		}
		return mav;
	}

	@RequestMapping(value="/examinePassword", method= RequestMethod.POST) 
	public void examinePassword(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
	    HttpSession session = request.getSession();
		//1. 获取参数
		String oldPassword = request.getParameter("password");
		System.out.println("oldPassword="+oldPassword);
		int sign=0, uid=0;
		if(session.getAttribute("uid")!=null)
		{
			uid= (Integer) session.getAttribute("uid");
			String password= userInfoService.getPasswordByUid(uid);
			System.out.println("password="+password);
			if(password.equals(oldPassword))
				sign=1;
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(String.valueOf(sign));
	}
	
}
