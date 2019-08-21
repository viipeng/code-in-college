package com.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.Shopping_trolley_food;
import com.digital.service.Shopping_trolley_foodService;


@RequestMapping("/shopping_trolley_food") 
@Controller//标识是一个控制器
public class Shopping_trolley_foodController {//全是后台方法

	@Autowired
    private Shopping_trolley_foodService Shopping_trolley_foodService;
	
	
	@RequestMapping("/selectBySfid") 
	public ModelAndView selectBySfid(String sfid1){
		int sfid=0;
		if(sfid1.length()!=0){
			sfid= Integer.valueOf(sfid1).intValue();	
		}
		List<Shopping_trolley_food> sf = Shopping_trolley_foodService.getSTFListBySfid(sfid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolley_food-list");
		mav.addObject("sfList", sf);
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(){
		List<Shopping_trolley_food> sfList = Shopping_trolley_foodService.getShopping_trolley_food();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolley_food-list");
		mav.addObject("sfList", sfList);
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolley_food-add");
		return mav;
	}
	
	@RequestMapping("/addShopping_trolley_food") 
	public ModelAndView addShopping_trolley_food(Shopping_trolley_food sf){
		Shopping_trolley_foodService.AddFoodToShopping_trolley(sf);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolley_food/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int sfid){
		List<Shopping_trolley_food> sf = Shopping_trolley_foodService.getSTFListBySfid(sfid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/shopping_trolley_food-upd");
		mav.addObject("sfList", sf);
		return mav;
	}
	
	@RequestMapping("/updateShopping_trolley_food") 
	public ModelAndView updateShopping_trolley_food(Shopping_trolley_food sf){
		Shopping_trolley_foodService.updateShopping_trolley_food(sf);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolley_food/selectAll");
		return mav;
	}

	@RequestMapping("/deleteShopping_trolley_food") 
	public ModelAndView deleteShopping_trolley_food(int sfid){
		Shopping_trolley_foodService.deleteSTFInfoBySfid(sfid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolley_food/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyShopping_trolley_food")
	public ModelAndView deleteManyShopping_trolley_food(String str){
		int sfid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				sfid= Integer.valueOf(temp).intValue();
				Shopping_trolley_foodService.deleteSTFInfoBySfid(sfid);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../shopping_trolley_food/selectAll");
		return mav;
	}
}
