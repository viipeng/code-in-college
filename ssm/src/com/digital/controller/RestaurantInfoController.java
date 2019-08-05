package com.digital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchFood;
import com.digital.pojo.MeauInfo;
import com.digital.pojo.Page_Food;
import com.digital.pojo.Pagination;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.Shopping_trolleyInfo;
import com.digital.pojo.UserInfo;
import com.digital.service.FoodInfoService;
import com.digital.service.MeauInfoService;
import com.digital.service.RestaurantInfoService;
import com.digital.service.Shopping_trolleyInfoService;
import com.digital.service.UserInfoService;


@RequestMapping("/restaurantInfo") 
@Controller//标识是一个控制器
public class RestaurantInfoController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
    private MeauInfoService meauInfoService;
	@Autowired
    private FoodInfoService foodInfoService;
	@Autowired
    private Shopping_trolleyInfoService shopping_trolleyInfoService;

//	public Pagination pagination;
	public Page_Food page_Food;
	
	
	@RequestMapping("/selectRestaurantNum") 
	public int selectRestaurantNum(){
		int restaurantNum;
		restaurantNum = restaurantInfoService.selectRestaurantNum();
		return restaurantNum;
	}
	
	//点击商家进入商家信息页面
	@RequestMapping("/visitRestaurantByRid")
	public ModelAndView visitRestaurantByRid(int rid, HttpSession session){
		session.setAttribute("isSearchFood", 0);//0表示没有在查找菜品
		ModelAndView mav = new ModelAndView();
		
		/*session.setAttribute("sort", "默认排序");*/
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		int pageId=1;
		
		//以下是Pagination的各种变量
//		pagination= new Pagination();
		page_Food= new Page_Food();
		page_Food.setPageSize(6);//6表示每页要显示6个菜品
		page_Food.setPageId(pageId);
		page_Food.setFirstThing(1-1);
		int mid= meauInfoList.get(0).getMid();//获得该餐馆第一个菜单的ID
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoByMid(mid));
		page_Food.setThingNum(page_Food.getAllFood().size());
		//求总页数
		if(page_Food.getThingNum()% page_Food.getPageSize()==0)
			page_Food.setPageNum(page_Food.getThingNum()/ page_Food.getPageSize());
		else
			page_Food.setPageNum((page_Food.getThingNum()/ page_Food.getPageSize())+1);
		//如果只有一页，则该页显示的菜品数量要少于规定的数量
		if(page_Food.getPageId()==page_Food.getPageNum())
			page_Food.setPageNowSize(page_Food.getThingNum()-((page_Food.getPageId()-1)*page_Food.getPageSize()));
		else
			page_Food.setPageNowSize(page_Food.getPageSize());
		List<FoodInfo> NowFood = new ArrayList<FoodInfo>();
		for(int i=0;i<page_Food.getPageNowSize();i++)
		{
			NowFood.add(i, page_Food.getAllFood().get(page_Food.getFirstThing()+i));
		}
		page_Food.setNowFood(NowFood);
		
		int star=getStar(restaurant.getRstar());

		//创建该用户在改餐馆的购物车
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			Shopping_trolleyInfo sti1 = new Shopping_trolleyInfo();//sti1只是用来存储uid和rid的
			sti1.setRid(rid);
			sti1.setUid(uid);
			sti1.setShipping_fee(restaurant.getShipping_fee());
			Shopping_trolleyInfo sti= shopping_trolleyInfoService.getSidByUidAndRid(sti1);//购物车模块写完后就不会出现查询不到的情况
			if(sti==null){
				shopping_trolleyInfoService.AddShopping_trolley(sti1);
//				sti= shopping_trolleyInfoService.getSidByUidAndRid(sti1);
			}
		}
		
//		List<FoodInfo> foodInfoList = foodInfoService.getFoodInfoByMid(mid);
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}
	
	//搜索菜品
	@RequestMapping("/searchFood")
	public ModelAndView searchFood(int rid, String name, HttpSession session){
		name='%'+name+'%';
		ForSearchFood forSearchFood = new ForSearchFood();
		forSearchFood.setRid(rid);
		forSearchFood.setName(name);
		ModelAndView mav = new ModelAndView();
		if(!foodInfoService.searchFood(forSearchFood).isEmpty())
		{
			
			int pageId=1,mid=1;
			page_Food.setAllFood(foodInfoService.searchFood(forSearchFood));
			page_Food.setThingNum(page_Food.getAllFood().size());//修改总餐馆数
			//修改总页数
			if(page_Food.getAllFood().size()% page_Food.getPageSize()==0)
				page_Food.setPageNum(page_Food.getAllFood().size()/ page_Food.getPageSize());
			else
				page_Food.setPageNum((page_Food.getAllFood().size()/ page_Food.getPageSize())+1);
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
			//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
			page_Food.setMid(mid);
			page(pageId);
			int star=getStar(restaurant.getRstar());
			session.setAttribute("isSearchFood", 1);//1表示在查找菜品
			mav.setViewName("jsp/restaurant");
			mav.addObject("mid", mid);
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
			mav.addObject("meauInfoList", meauInfoList);
			mav.addObject("foodInfoList", page_Food.getNowFood());
			mav.addObject("pageNum", page_Food.getPageNum());
			mav.addObject("pageId", page_Food.getPageId());
		}
		else{
			JOptionPane.showMessageDialog(null, "商品查找失败，没有这类商品", "查找结果", JOptionPane.PLAIN_MESSAGE);
			mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+rid);
		}
		return mav;
	}

	//按菜单查看菜品
	@RequestMapping("/selectByMid")
	public ModelAndView selectByMid(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "默认排序");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoByMid(mid));
		page(pageId);
		int star=getStar(restaurant.getRstar());
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}

	//按销量查看菜品
	@RequestMapping("/selectBySales_volume")
	public ModelAndView selectBySales_volume(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "销量");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoBySales_volume(mid));
		page(pageId);
		int star=getStar(restaurant.getRstar());
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}

	//按价格由低到高查看菜品
	@RequestMapping("/selectByPrice")
	public ModelAndView selectByPrice(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "价格低到高");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoByPrice(mid));
		page(pageId);
		int star=getStar(restaurant.getRstar());
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}

	//按价格由高到低查看菜品
	@RequestMapping("/selectByPrice1")
	public ModelAndView selectByPrice1(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "价格高到低");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoByPrice1(mid));
		page(pageId);
		int star=getStar(restaurant.getRstar());
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}

	//切换到指定页，菜单是哪个无所谓，只需用page()方法修改PageNowSize即可
	@RequestMapping("/pageFood") 
	public ModelAndView pageFood(int pageId, int mid, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		//接下来的两步是为了方便前台商家界面的浏览，把只有一个元素的restaurantList换成restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		page(pageId);
		int star=getStar(restaurant.getRstar());
		mav.setViewName("jsp/restaurant");
		mav.addObject("mid", mid);
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("meauInfoList", meauInfoList);
		mav.addObject("foodInfoList", page_Food.getNowFood());
		mav.addObject("pageNum", page_Food.getPageNum());
		mav.addObject("pageId", page_Food.getPageId());
		return mav;
	}

	//与restaurant相比多了page_Food.setPageNum()和
	private void page(int pageId)
	{
		page_Food.setThingNum(page_Food.getAllFood().size());
		//求总页数
		if(page_Food.getThingNum()% page_Food.getPageSize()==0)
			page_Food.setPageNum(page_Food.getThingNum()/ page_Food.getPageSize());
		else
			page_Food.setPageNum((page_Food.getThingNum()/ page_Food.getPageSize())+1);
		page_Food.setPageId(pageId);
		page_Food.setFirstThing((page_Food.getPageId()-1)*page_Food.getPageSize());
		if(page_Food.getPageId()==page_Food.getPageNum())//最后一页
			page_Food.setPageNowSize(page_Food.getThingNum()-((page_Food.getPageId()-1)*page_Food.getPageSize()));
		else
			page_Food.setPageNowSize(page_Food.getPageSize());
		List<FoodInfo> NowFood = new ArrayList<FoodInfo>();
		for(int i=0;i<page_Food.getPageNowSize();i++)
		{
//			System.out.println("当前页要显示的餐馆数为："+page_Food.getPageNowSize());
			if(page_Food.getAllFood().size()>0)
				NowFood.add(i, page_Food.getAllFood().get(page_Food.getFirstThing()+i));
		}
		page_Food.setNowFood(NowFood);
	}

	//为了显示餐馆的星级
	public int getStar(float rstar){
		int star= (int)rstar;
//		System.out.println("餐馆星级为"+star);
		return star;
	}
	
	//后台
	@RequestMapping("/selectByRid") 
	public ModelAndView selectByRid(String rid1){
		int rid=0;
		if(rid1.length()!=0){
			rid= Integer.valueOf(rid1).intValue();	
		}
		List<RestaurantInfo> ri = restaurantInfoService.getRestaurantInfoByRid(rid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/restaurant-list");
		mav.addObject("riList", ri);
		return mav;
	}

	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")==null)
		{
			List<RestaurantInfo> riList = restaurantInfoService.getRestaurantInfo();
			mav.addObject("riList", riList);
		}
		else{
			int rid= (Integer) session.getAttribute("rid");
			List<RestaurantInfo> riList = restaurantInfoService.getRestaurantInfoByRid(rid);
			mav.addObject("riList", riList);
		}
		mav.setViewName("houtai/restaurant-list");
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/restaurant-add");
		return mav;
	}
	
	@RequestMapping("/addRestaurant") 
	public ModelAndView addRestaurant(RestaurantInfo ri){
		restaurantInfoService.addRestaurantInfo(ri);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../restaurantInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int rid){
		List<RestaurantInfo> ri = restaurantInfoService.getRestaurantInfoByRid(rid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/restaurant-upd");
		mav.addObject("riList", ri);
		return mav;
	}
	
	@RequestMapping("/updateRestaurant") 
	public ModelAndView updateRestaurant(RestaurantInfo ri){
		restaurantInfoService.updateRestaurantInfo(ri);//updateDelivererInfo(di);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../restaurantInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteRestaurant") 
	public ModelAndView deleteRestaurant(int rid){
		restaurantInfoService.deleteRestaurantInfo(rid);//deleteDelivererInfoByDid(rid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../restaurantInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteManyRestaurant")
	public ModelAndView deleteManyRestaurant(String str){
		int rid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				rid= Integer.valueOf(temp).intValue();
				restaurantInfoService.deleteRestaurantInfo(rid);//deleteDelivererInfoByDid(did);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../restaurantInfo/selectAll");
		return mav;
	}
	
}
