package com.digital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.FoodInfo;
import com.digital.pojo.Order_food;
import com.digital.pojo.Shopping_trolleyInfo;
import com.digital.pojo.Shopping_trolleyInfoAdd;
import com.digital.pojo.Shopping_trolley_food;
import com.digital.service.FoodInfoService;
import com.digital.service.Shopping_trolleyInfoAddService;
import com.digital.service.Shopping_trolleyInfoService;
import com.digital.service.Shopping_trolley_foodService;

@RequestMapping("/shopping_trolleyInfo") 
@Controller//标识是一个控制器
public class Shopping_trolleyInfoController {

	@Autowired
    private Shopping_trolleyInfoService shopping_trolleyInfoService;
	@Autowired
    private FoodInfoService foodInfoService;
	@Autowired
    private Shopping_trolleyInfoAddService shopping_trolleyInfoAddService;
	@Autowired
    private Shopping_trolley_foodService shopping_trolley_foodService;

	@RequestMapping("/AddFoodToShopping_trolley")
	public ModelAndView AddFoodToShopping_trolley(int rid, int fid, HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("uid")!=null){
			int uid= (Integer) session.getAttribute("uid");
			Shopping_trolleyInfo sti1 = new Shopping_trolleyInfo();//sti1只是用来存储uid和rid的
			sti1.setRid(rid);
			sti1.setUid(uid);
			Shopping_trolleyInfo sti= shopping_trolleyInfoService.getSidByUidAndRid(sti1);
			Shopping_trolley_food stf1= new Shopping_trolley_food();
			stf1.setSid(sti.getSid());
			stf1.setFid(fid);
			Shopping_trolley_food stf= shopping_trolley_foodService.getSTFoodBySidAndFId(stf1);
			if(stf==null){
				List<FoodInfo> foodList= foodInfoService.getFoodInfoByFid(fid);
				FoodInfo food= foodList.get(0);
				stf1.setAmount(1);
				stf1.setFname(food.getFname());
				stf1.setFphoto(food.getFphoto());
				stf1.setFprice(food.getFprice());
				shopping_trolley_foodService.AddFoodToShopping_trolley(stf1);//把一个菜品添加进购物车
			}
			else{
				stf.setAmount(stf.getAmount()+1);
				shopping_trolley_foodService.UpdateAmountOfSTFood(stf);//增加菜品的数量
			}
			updateSumTotal(sti.getSid());
			String url= request.getHeader("referer");
			if(url.compareTo("http://localhost:8080/ssm/restaurantInfo/searchFood")==0)
				mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+rid);
			else
				mav.setViewName("redirect:"+url);
//			System.out.println("刷新的网址为"+url);
		}
		else{
			mav.setViewName("redirect:../home/login");
		}
		return mav;
	}

	@RequestMapping("/AddAmountOfSTFood")
	public ModelAndView AddAmountOfSTFood(int sfid, int rid){
		Shopping_trolley_food stf= shopping_trolley_foodService.getSTFInfoBySfid(sfid);
		stf.setAmount(stf.getAmount()+1);
		shopping_trolley_foodService.UpdateAmountOfSTFood(stf);
		updateSumTotal(stf.getSid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfoAdd/visitShopping_trolley?rid="+rid);
		return mav;
	}

	@RequestMapping("/SubAmountOfSTFood")
	public ModelAndView SubAmountOfSTFood(int sfid, int rid){ 
		Shopping_trolley_food stf= shopping_trolley_foodService.getSTFInfoBySfid(sfid);
		stf.setAmount(stf.getAmount()-1);
		if(stf.getAmount()==0)
			shopping_trolley_foodService.deleteSTFInfoBySfid(sfid);
		else
			shopping_trolley_foodService.UpdateAmountOfSTFood(stf);
		updateSumTotal(stf.getSid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfoAdd/visitShopping_trolley?rid="+rid);
		return mav;
	}

	@RequestMapping("/DeleteSTFoodBySfid")
	public ModelAndView DeleteSTFoodBySfid(int sfid, int rid){ 
		Shopping_trolley_food stf= shopping_trolley_foodService.getSTFInfoBySfid(sfid);
		shopping_trolley_foodService.deleteSTFInfoBySfid(sfid);
		updateSumTotal(stf.getSid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfoAdd/visitShopping_trolley?rid="+rid);
		return mav;
	}
	
	/*@RequestMapping("/AddShopping_trolley")
	public ModelAndView AddShopping_trolley(int mid, int uid, int fid){ 
		shopping_trolleyInfoService.AddShopping_trolley(uid, fid);
		List<FoodInfo> fiList = foodInfoService.getFoodInfoByMid(mid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/food");
		mav.addObject("fiList", fiList);
		mav.addObject("mid", mid);
		mav.addObject("uid", uid);
		return mav;
	}*/
	
	/*@RequestMapping("/DeleteShopping_trolley")
	public ModelAndView DeleteShopping_trolley(int uid, int sid){ 
		shopping_trolleyInfoService.DeleteShopping_trolley(sid);
		List<Shopping_trolleyInfoAdd> stiaList= shopping_trolleyInfoAddService.getShopping_trolleyInfo(uid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/shopping_trolley");
		mav.addObject("stiaList", stiaList);
		mav.addObject("uid", uid);
		return mav;	
	}*/

	/*@RequestMapping("/AddShopping_trolleyInRankingList")
	public ModelAndView AddShopping_trolleyInRankingList(int mid, int uid, int fid){ 
		shopping_trolleyInfoService.AddShopping_trolley(uid, fid);
		List<FoodInfo> rkList = foodInfoService.getRankingList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/ranking_list");
		mav.addObject("rkList", rkList);
		mav.addObject("mid", mid);
		mav.addObject("uid", uid);
		return mav;
	}*/
	
	public void updateSumTotal(int sid){
		List<Shopping_trolley_food> stfList= shopping_trolley_foodService.getShopping_trolley_foodList(sid);
		float total=0;
		int foodSum=0;
		for(int i=0; i<stfList.size(); i++)
		{
			total+= stfList.get(i).getFprice()*stfList.get(i).getAmount();
			foodSum+= stfList.get(i).getAmount();
		}
		Shopping_trolleyInfo sti= new Shopping_trolleyInfo();
		sti.setSid(sid);
		sti.setFoodSum(foodSum);
		sti.setTotal(total);
		shopping_trolleyInfoService.CompleteShopping_trolley(sti);//将数据传入数据库*/
	}

	//后台
	@RequestMapping("/selectBySid") 
	public ModelAndView selectBySid(String sid1){
		int sid=0;
		if(sid1.length()!=0){
			sid= Integer.valueOf(sid1).intValue();
		}
		List<Shopping_trolleyInfo> sti = shopping_trolleyInfoService.getSTInfoBySid(sid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolleyInfo-list");
		mav.addObject("stiList", sti);
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(){
		List<Shopping_trolleyInfo> stiList = shopping_trolleyInfoService.getShopping_trolleyInfo();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolleyInfo-list");
		mav.addObject("stiList", stiList);
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolleyInfo-add");
		return mav;
	}
	
	@RequestMapping("/addSTInfo") 
	public ModelAndView addSTInfo(Shopping_trolleyInfo sti){
		shopping_trolleyInfoService.addSTInfo(sti);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int sid){
		List<Shopping_trolleyInfo> sti = shopping_trolleyInfoService.getSTInfoBySid(sid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolleyInfo-upd");
		mav.addObject("stiList", sti);
		return mav;
	}
	
	@RequestMapping("/updateSTInfo") 
	public ModelAndView updateSTInfo(Shopping_trolleyInfo sti){
		shopping_trolleyInfoService.updateSTInfo(sti);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteSTInfo") 
	public ModelAndView deleteSTInfo(int sid){
		shopping_trolleyInfoService.DeleteShopping_trolley(sid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfo/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManySTInfo")
	public ModelAndView deleteManySTInfo(String str){
		int sid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				sid= Integer.valueOf(temp).intValue();
				shopping_trolleyInfoService.DeleteShopping_trolley(sid);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolleyInfo/selectAll");
		return mav;
	}
	
}
