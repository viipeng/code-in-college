package com.digital.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.AddMoney;
import com.digital.pojo.MerchantInfo;
import com.digital.pojo.OrderInfo;
import com.digital.pojo.RestaurantInfo;
import com.digital.service.AddMoneyService;
import com.digital.service.MerchantService;
import com.digital.service.OrderInfoService;
import com.digital.service.RestaurantInfoService;

@RequestMapping("/merchant") 
@Controller//标识是一个控制器
public class MerchantController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
    private MerchantService merchantService;
	@Autowired
    private OrderInfoService orderInfoService;
	@Autowired
	private AddMoneyService addMoneyService;
	
	private List<OrderInfo> orderList;
	
	@RequestMapping("/login") 
	public ModelAndView login(MerchantInfo mi, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		MerchantInfo me=merchantService.getMerchantByCode(mi);
		if(me!=null && me.getMerchantName()!=null){
//			System.out.println("商家信息为"+me.toString());
			session.setAttribute("rid",me.getRid());
			mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+me.getRid());
			return mav;
		}
		else{
			mav.setViewName("redirect:../home/merchantLogin");
			return mav;
		}
	}
	
	//refund.jsp页面
	@RequestMapping("/refundRequest") 
	public ModelAndView refundRequest(HttpSession session) throws ParseException
	{
		System.out.println("到了退款这里");
		ModelAndView mav = new ModelAndView();
		int todayRequestSum=0, noProcessSum=0;
		List<OrderInfo> noOrderList= new LinkedList<OrderInfo>();//待退款的订单
		List<OrderInfo> haveOrderList= new LinkedList<OrderInfo>();//已退款的订单
		List<OrderInfo> requestList= new LinkedList<OrderInfo>();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			noOrderList= orderInfoService.getROrderByRid1(rid);
			haveOrderList= orderInfoService.getROrderByRid2(rid);
			for(OrderInfo order: noOrderList){
				requestList.add(order);
			}
			for(OrderInfo order: haveOrderList){
				requestList.add(order);
			}
			System.out.println("该餐馆的退款的退款订单是：");
			for(OrderInfo order: requestList){
				System.out.println(order.toString());
			}
		}
//		System.out.println(requestList.toString());
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String today = String.valueOf(date.get(Calendar.DATE));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = format.parse(year+"-"+month+"-"+today+" 00:00:00");
//		System.out.println("开始日期为："+begin);
		Date end = date.getTime();
//		System.out.println("结束日期为："+end);
		for (OrderInfo orequest : noOrderList) {
			Date time = format.parse(orequest.getOdate());
			if(isBetweenTwoDate(time, begin, end)){
				todayRequestSum++;
			}
		}
		noProcessSum= noOrderList.size();
//		System.out.println("今天的请求数量为："+todayRequestSum+",未处理的请求数量为："+noProcessSum);
		mav.addObject("todayRequestSum", todayRequestSum);
		mav.addObject("noProcessSum", noProcessSum);
		mav.addObject("requestList", requestList);
		mav.setViewName("houtai/refund");
		return mav;
	}
		
	
	@RequestMapping("/jumpToHoutai") 
	public ModelAndView jumpToHoutai()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../bossInfo/home?bid="+1);//因为boss只有一个
		return mav;
	}

	@RequestMapping("/income") 
	public ModelAndView income(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			orderList= orderInfoService.getOrderInfoByRid(rid);
			float finishSum=0, noPaySum=0, noRefundSum=0, hasRefundSum= 0, on_waySum=0;
			
			//restaurant_header.jsp文件有用到的参数
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
			
			Calendar date = Calendar.getInstance();
			String year = String.valueOf(date.get(Calendar.YEAR));
			String month = String.valueOf(date.get(Calendar.MONTH)+1);
			String today = String.valueOf(date.get(Calendar.DATE));
			String tomorrow = String.valueOf(date.get(Calendar.DATE)+1);//明天
			mav.addObject("year", year);
			
			//计算今日收益
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date begin = format.parse(year+"-"+month+"-"+today+" 00:00:00");
//				Date end = format.parse(year+"-"+month+"-"+tomorrow+" 00:00:00");
				Date end = date.getTime();//获取当前时间
				for (OrderInfo order : orderList) {
					Date time = format.parse(order.getOdate());
					if(isBetweenTwoDate(time, begin, end)){
//						System.out.println(order.getOid()+"在");
						if(order.getOstate().equals("待评价") || order.getOstate().equals("完成"))
							finishSum+= order.getConsumption();
						else if(order.getOstate().equals("待付款"))
							noPaySum+= order.getConsumption();
						else if(order.getOstate().equals("待退款"))
							noRefundSum+= order.getConsumption();
						else if(order.getOstate().equals("已退款"))
							hasRefundSum+= order.getConsumption();
						else if(order.getOstate().equals("途中"))
							on_waySum+= order.getConsumption();
					}
					/*else{
						System.out.println(order.getOid()+"不在");
					}*/
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//为了只保留小数点后一位
			finishSum= (float)(Math.round(finishSum*10))/10;
			noPaySum= (float)(Math.round(noPaySum*10))/10;
			noRefundSum= (float)(Math.round(noRefundSum*10))/10;
			hasRefundSum= (float)(Math.round(hasRefundSum*10))/10;
			on_waySum= (float)(Math.round(on_waySum*10))/10;
			
			mav.addObject("finishSum", finishSum);
			mav.addObject("noPaySum", noPaySum);
			mav.addObject("noRefundSum", noRefundSum);
			mav.addObject("hasRefundSum", hasRefundSum);
			mav.addObject("on_waySum", on_waySum);
		}
		mav.setViewName("jsp/income");
		return mav;
	}

	@RequestMapping(value="/getMonth", method= RequestMethod.GET) 
	public void getMonth(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			String month= Integer.toString(12);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(month);
//			System.out.println("共有"+month+"个月");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getDay", method= RequestMethod.POST) 
	public void getDay(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			//1. 获取参数
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			int mon[]={31,0,31,30,31,30,31,31,30,31,30,31};
			if(year%4==0){
				if(year%100==0&&year%400!=0)
					mon[1]=28;
			    else
			    	mon[1]=29;
			}
			else
				mon[1]=28;
			String day= Integer.toString(mon[month-1]);
//			System.out.println("年份是"+year+",月份是"+month+",日子是"+day);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(day);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/oneDayIncome", method= RequestMethod.POST) 
	public void oneDayIncome(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException
	{
		float finishSum1=0;
		//1. 获取参数
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String day = request.getParameter("day");
		int day1 = Integer.parseInt(request.getParameter("day"));
//		int day2 = day1+1;
		String tommorrow = String.valueOf(day1+1);
		/*System.out.println("年份是"+year+",月份是"+month+",日子是"+day);
		System.out.println("年份是"+year+",月份是"+month+",明天是"+day2);
		System.out.println("年份是"+year+",月份是"+month+",明天是"+tommorrow);*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = format.parse(year+"-"+month+"-"+day+" 00:00:00");
//		System.out.println("开始日期为："+begin);
		Date end = format.parse(year+"-"+month+"-"+tommorrow+" 00:00:00");
//		System.out.println("结束日期为："+end);
		for (OrderInfo order : orderList) {
			Date time = format.parse(order.getOdate());
			if(isBetweenTwoDate(time, begin, end)){
//				System.out.println(time);
				if(order.getOstate().equals("待评价") || order.getOstate().equals("完成"))
					finishSum1+= order.getConsumption();
			}
		}
		finishSum1= (float)(Math.round(finishSum1*10))/10;
		String finishSum= String.valueOf(finishSum1);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(finishSum);
	}

	@RequestMapping(value="/todayIncome", method= RequestMethod.GET)
	public void todayIncome(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException
	{
		float finishSum=0, noPaySum=0, noRefundSum=0, hasRefundSum= 0, on_waySum=0;
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String today = String.valueOf(date.get(Calendar.DATE));
//		String tomorrow = String.valueOf(date.get(Calendar.DATE)+1);//明天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = format.parse(year+"-"+month+"-"+today+" 00:00:00");
//		System.out.println("开始日期为："+begin);
		Date end = date.getTime();
//		System.out.println("结束日期为："+end);
		//计算总收益
		for (OrderInfo order : orderList) {
			Date time = format.parse(order.getOdate());
			if(isBetweenTwoDate(time, begin, end)){
				if(order.getOstate().equals("待评价") 
						|| order.getOstate().equals("完成"))
					finishSum+= order.getConsumption();
				else if(order.getOstate().equals("待付款"))
					noPaySum+= order.getConsumption();
				else if(order.getOstate().equals("待退款"))
					noRefundSum+= order.getConsumption();
				else if(order.getOstate().equals("已退款"))
					hasRefundSum+= order.getConsumption();
				else if(order.getOstate().equals("途中"))
					on_waySum+= order.getConsumption();
			}
		}
		//为了只保留小数点后一位
		finishSum= (float)(Math.round(finishSum*10))/10;
		noPaySum= (float)(Math.round(noPaySum*10))/10;
		noRefundSum= (float)(Math.round(noRefundSum*10))/10;
		hasRefundSum= (float)(Math.round(hasRefundSum*10))/10;
		on_waySum= (float)(Math.round(on_waySum*10))/10;
		/*System.out.println("finishSum="+finishSum+" noPaySum="+noPaySum+" noRefundSum="
				+noRefundSum+" hasRefundSum-"+hasRefundSum+" on_waySum="+on_waySum);*/
		List<String> income = new LinkedList<String>();
		income.add("今日收益："+String.valueOf(finishSum)+"元");
		income.add("待付款的订单总额为："+String.valueOf(noPaySum)+"元");
		income.add("待送达的订单总额为："+String.valueOf(on_waySum)+"元");
		income.add("待退款的订单总额为："+String.valueOf(noRefundSum)+"元");
		income.add("已退款的订单总额为："+String.valueOf(hasRefundSum)+"元");
		/*for (String string : income) {
			System.out.println(string);
		}*/
//		System.out.println(income.toString());
		JSONArray jsonArray = JSONArray.fromObject(income);
		String json = jsonArray.toString();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
//		return income;
	}

	@RequestMapping(value="/yesterdayIncome", method= RequestMethod.GET) 
	@ResponseBody
	public String yesterdayIncome(HttpServletRequest request, HttpServletResponse response)
	{
		float finishSum1=0;
		try {
			Calendar date = Calendar.getInstance();
			String year = String.valueOf(date.get(Calendar.YEAR));
			String month = String.valueOf(date.get(Calendar.MONTH)+1);
			String yesterday = String.valueOf(date.get(Calendar.DATE)-1);
//			System.out.println("昨天为："+yesterday);
			String today = String.valueOf(date.get(Calendar.DATE));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin = format.parse(year+"-"+month+"-"+yesterday+" 00:00:00");
//			System.out.println("开始日期为："+begin);
			Date end = format.parse(year+"-"+month+"-"+today+" 00:00:00");
//			System.out.println("结束日期为："+end);
			for (OrderInfo order : orderList) {
				Date time = format.parse(order.getOdate());
				if(isBetweenTwoDate(time, begin, end)){
//					System.out.println(time);
					if(order.getOstate().equals("待评价") || order.getOstate().equals("完成"))
						finishSum1+= order.getConsumption();
				}
			}
			finishSum1= (float)(Math.round(finishSum1*10))/10;
			/*response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(finishSum);*/
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String finishSum= String.valueOf(finishSum1);
//		System.out.println("收益为："+finishSum1);
//		System.out.println("收益为："+finishSum);
		return finishSum;
	}

	@RequestMapping(value="/monthIncome", method= RequestMethod.GET) 
	public void monthIncome(HttpServletRequest request, HttpServletResponse response)
	{
		float finishSum1=0;
		try {
			Calendar date = Calendar.getInstance();
			String year = String.valueOf(date.get(Calendar.YEAR));
			String month = String.valueOf(date.get(Calendar.MONTH)+1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin = format.parse(year+"-"+month+"-01"+" 00:00:00");//本月1号
			System.out.println("开始日期为："+begin);//获取当前时间
			Date end = date.getTime();
			System.out.println("结束日期为："+end);
			/*HttpSession session= request.getSession();
			if(session.getAttribute("rid")!=null)
			{
				int rid= (Integer) session.getAttribute("rid");
				orderList= orderInfoService.getOrderInfoByRid(rid);
			}*/
			int j=1;
			for (OrderInfo order : orderList) {
				Date time = format.parse(order.getOdate());
//				System.out.print(order.getOid()+"的时间为"+time+"  ");
				if(isBetweenTwoDate(time, begin, end)){
//					System.out.print("在时间范围内  ");
					if(order.getOstate().equals("待评价") || order.getOstate().equals("完成")){
						finishSum1+= order.getConsumption();
//						System.out.println("已完成");
					}/*
					else{
						System.out.println("没有完成");
					}*/
				}/*
				else{
					System.out.println("不在时间范围内  ");
				}*/
			}
			finishSum1= (float)(Math.round(finishSum1*10))/10;
			String finishSum= String.valueOf(finishSum1);
//			System.out.println("float收益为："+finishSum1);
//			System.out.println("String收益为："+finishSum);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(finishSum);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/queryAccount", method= RequestMethod.GET)  
	@ResponseBody
	public String queryAccount(HttpServletRequest request, HttpServletResponse response)
	{
	    HttpSession session = request.getSession();
	    float account=0;
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			account= merchantService.queryAccount(rid);
		}
		return String.valueOf(account);
	}

	@RequestMapping("/jumpToChangePassword") 
	public ModelAndView jumpToChangePassword(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			//restaurant_header.jsp文件有用到的参数
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		mav.setViewName("jsp/changePassword");
		return mav;
	}

	@RequestMapping("/changePassword") 
	public ModelAndView changePassword(HttpSession session, String mpassword)
	{
		ModelAndView mav = new ModelAndView();
		MerchantInfo mi = new MerchantInfo();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			mi.setRid(rid);
			mi.setMpassword(mpassword);
			merchantService.changePassword(mi);
			mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+rid);
		}
		return mav;
	}

	@RequestMapping(value="/examinePassword", method= RequestMethod.POST) 
	public void examinePassword(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
	    HttpSession session = request.getSession();
		//1. 获取参数
		String mpassword = request.getParameter("mpassword");
		int sign=0, rid=0;
		if(session.getAttribute("rid")!=null)
		{
			rid= (Integer) session.getAttribute("rid");
			String password= merchantService.getPasswordByRid(rid);
			if(password.equals(mpassword))
				sign=1;
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(String.valueOf(sign));
//		System.out.println("sign="+sign);
	}
	
	public boolean isBetweenTwoDate(Date date, Date startDate, Date endDate) { 
		if(date.equals(startDate))
			return true;
		else
			return startDate.before(date) && endDate.after(date); 
	}

	@RequestMapping("/jumpToAddMoney") 
	public ModelAndView jumpToAddMoney(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			//restaurant_header.jsp文件有用到的参数
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
			mav.setViewName("jsp/addMoney");
		}
		return mav;
	}

	@RequestMapping("/addMoney") 
	public ModelAndView addMoney(int money, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			//新建一个AddMoney类
			AddMoney am= new AddMoney();
			am.setId(rid);
			am.setMoney(money);
			am.setState(0);//0表示还未被处理，1表示处理完毕
			am.setStatus("merchant");
			String name= merchantService.getNameByRid(rid);
			am.setName(name);
			Date date= new Date();
			String adate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
			am.setAdate(adate);
			addMoneyService.creatPetition(am);
			mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+rid);
		}
		return mav;
	}
	
}
