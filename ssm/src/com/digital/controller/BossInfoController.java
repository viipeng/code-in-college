package com.digital.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.AddMoney;
import com.digital.pojo.BossInfo;
import com.digital.pojo.MerchantInfo;
import com.digital.pojo.OrderInfo;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.UserInfo;
import com.digital.service.AddMoneyService;
import com.digital.service.BossInfoService;
import com.digital.service.MerchantService;
import com.digital.service.OrderInfoService;
import com.digital.service.RestaurantInfoService;
import com.digital.service.UserInfoService;

@RequestMapping("/bossInfo") 
@Controller//标识是一个控制器
public class BossInfoController {
	
	@Autowired
    private BossInfoService bossInfoService;
	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
	private AddMoneyService addMoneyService;
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
    private MerchantService merchantService;
	@Autowired
    private OrderInfoService orderInfoService;
	
	@RequestMapping("/login") 
	public ModelAndView login(BossInfo bi)
	{
		ModelAndView mav = new ModelAndView();
		BossInfo bo=bossInfoService.getBossInfoByCode(bi);
		if(bo!=null && bo.getBusername()!=null){
			mav.setViewName("redirect:../bossInfo/home?bid="+bo.getBid());
			mav.addObject("bi", bo);
			return mav;
		}
		else{
			mav.setViewName("houtai/login");
			return mav;
		}
	}

	@RequestMapping("/home") 
	public ModelAndView home(int bid, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			mav.addObject("restaurant", restaurant);
		}
		else{
			BossInfo bo= bossInfoService.getBossInfoByBid(bid);
			mav.addObject("bi", bo);
		}
		mav.setViewName("houtai/homepage-list");
		return mav;
	}
	
	//welcome.jsp页面
	@RequestMapping("/moneyRequest") 
	public ModelAndView moneyRequest() throws ParseException
	{
		System.out.println("到了充值这里");
		ModelAndView mav = new ModelAndView();
		int todayRequestSum=0, noProcessSum=0;
		List<AddMoney> requestList= new LinkedList<AddMoney>();
		requestList= addMoneyService.getAllRequest();
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String today = String.valueOf(date.get(Calendar.DATE));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = format.parse(year+"-"+month+"-"+today+" 00:00:00");
//		System.out.println("开始日期为："+begin);
		Date end = date.getTime();
//		System.out.println("结束日期为："+end);
		for (AddMoney mrequest : requestList) {
			Date time = format.parse(mrequest.getAdate());
			if(isBetweenTwoDate(time, begin, end)){
				todayRequestSum++;
			}
			if(mrequest.getState()==0){
				noProcessSum++;
			}
		}
//		System.out.println("今天的请求数量为："+todayRequestSum+",未处理的请求数量为："+noProcessSum);
		mav.addObject("todayRequestSum", todayRequestSum);
		mav.addObject("noProcessSum", noProcessSum);
		mav.addObject("requestList", requestList);
		mav.setViewName("houtai/welcome");
		return mav;
	}
	
	@RequestMapping("/permit") 
	public ModelAndView permit(int aid, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		AddMoney am= new AddMoney();
		am= addMoneyService.getAddMoneyByAid(aid);
		am.setState(1);
		addMoneyService.permit(am);
		if(am.getStatus().equals("user")){
			int uid= am.getId();
			UserInfo ui= userInfoService.getUserInfoByUid(uid);
			ui.setAccount_balance(ui.getAccount_balance()+am.getMoney());
			userInfoService.addmoney(ui);
		}
		else if(am.getStatus().equals("merchant")){
			int rid= am.getId();
			MerchantInfo mi= merchantService.getMerchantByRid(rid);
			mi.setAccount_balance(mi.getAccount_balance()+am.getMoney());
			merchantService.addMoney(mi);
		}
		mav.setViewName("redirect:../bossInfo/moneyRequest");
		return mav;
	}

	@RequestMapping("/refuse") 
	public ModelAndView refuse(int aid, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		AddMoney am= new AddMoney();
		am= addMoneyService.getAddMoneyByAid(aid);
		am.setState(2);
		addMoneyService.refuse(am);
		mav.setViewName("redirect:../bossInfo/moneyRequest");
		return mav;
	}

	public boolean isBetweenTwoDate(Date date, Date startDate, Date endDate) { 
		if(date.equals(startDate))
			return true;
		else
			return startDate.before(date) && endDate.after(date); 
	}

}
