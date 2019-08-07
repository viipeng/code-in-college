package com.digital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.RestaurantInfo;
import com.digital.service.FoodInfoService;
import com.digital.service.RestaurantInfoService;

@RequestMapping("/foodInfo") 
@Controller//标识是一个控制器
public class FoodInfoController {

	@Autowired
    private FoodInfoService foodInfoService;
	@Autowired
    private RestaurantInfoService restaurantInfoService;
	
	@RequestMapping("/visitFoodByFid")
	public ModelAndView visitFoodByFid(int fid, int rid)
	{
		List<FoodInfo> fiList = foodInfoService.getFoodInfoByFid(fid);
		FoodInfo food = fiList.get(0);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//为了协调与后台商家列表的显示，getRestaurantInfoByRid方法的返回类型是List<RestaurantInfo>
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/food");
		mav.addObject("food", food);
		mav.addObject("restaurant", restaurant);
		return mav;
	}
	
	@RequestMapping("/getFood")
	public ModelAndView getFood(int mid, int uid)
	{
		List<FoodInfo> fiList = foodInfoService.getFoodInfoByMid(mid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/food");
		mav.addObject("fiList", fiList);
		mav.addObject("mid", mid);
		mav.addObject("uid", uid);
		return mav;
	}
	
	@RequestMapping("/getRankingList")
	public ModelAndView getRankingList(int uid)
	{
		List<FoodInfo> rkList = foodInfoService.getRankingList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/ranking_list");
		mav.addObject("rkList", rkList);
		mav.addObject("uid", uid);
		return mav;
	}
	
	//后台
	@RequestMapping("/selectByFid") 
	public ModelAndView selectByFid(String fid1, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int fid=0;
		if(fid1.length()!=0){
			fid= Integer.valueOf(fid1).intValue();	
		}
		if(session.getAttribute("rid")==null)
		{
			List<FoodInfo> fi = foodInfoService.getFoodInfoByFid(fid);
			mav.addObject("fiList", fi);
		}
		else{
			ForSearchOfRid fe= new ForSearchOfRid();
			int rid= (Integer) session.getAttribute("rid");
			fe.setRid(rid);
			fe.setFid(fid);
			List<FoodInfo> fi = foodInfoService.getFoodInfoByFidOfRid(fe);
			mav.addObject("fiList", fi);
		}
		mav.setViewName("houtai/food-list");
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")==null)
		{
			List<FoodInfo> fiList = foodInfoService.getFoodInfo();
			mav.addObject("fiList", fiList);
		}
		else{
			int rid= (Integer) session.getAttribute("rid");
			List<FoodInfo> fiList = foodInfoService.getFoodInfoByRid(rid);
			mav.addObject("fiList", fiList);
		}
		mav.setViewName("houtai/food-list");
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/food-add");
		return mav;
	}
	
	@RequestMapping("/addFood") 
	public ModelAndView addFood(FoodInfo fi){
		foodInfoService.addFoodInfo(fi);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../foodInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int fid){
		List<FoodInfo> fi = foodInfoService.getFoodInfoByFid(fid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/food-upd");
		mav.addObject("fiList", fi);
		return mav;
	}
	
	@RequestMapping("/updateFood") 
	public ModelAndView updateFood(FoodInfo fi){
		foodInfoService.updateFoodInfo(fi);//updateDelivererInfo(di);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../foodInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteFood") 
	public ModelAndView deleteFood(int fid){
		foodInfoService.deleteFoodInfo(fid);//deleteDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../foodInfo/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyFood")
	public ModelAndView deleteManyFood(String str){
		int fid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				fid= Integer.valueOf(temp).intValue();
				foodInfoService.deleteFoodInfo(fid);//deleteDelivererInfoByDid(did);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../foodInfo/selectAll");
		return mav;
	}
}
