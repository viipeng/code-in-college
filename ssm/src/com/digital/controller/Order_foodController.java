package com.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.Order_food;
import com.digital.service.Order_foodService;


@RequestMapping("/order_food") 
@Controller//标识是一个控制器
public class Order_foodController {//全是后台的方法

	@Autowired
    private Order_foodService order_foodService;
	
	
	@RequestMapping("/selectByOFid") 
	public ModelAndView selectByOFid(String ofid1){
		int ofid=0;
		if(ofid1.length()!=0){
			ofid= Integer.valueOf(ofid1).intValue();	
		}
		List<Order_food> of = order_foodService.getOrder_foodByOFid(ofid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order_food-list");
		mav.addObject("ofList", of);
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(){
		List<Order_food> ofList = order_foodService.getOrder_food();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order_food-list");
		mav.addObject("ofList", ofList);
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order_food-add");
		return mav;
	}
	
	@RequestMapping("/addOrder_food") 
	public ModelAndView addOrder_food(Order_food of){
		order_foodService.addOrder_food(of);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../order_food/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int ofid){
		List<Order_food> of = order_foodService.getOrder_foodByOFid(ofid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order_food-upd");
		mav.addObject("ofList", of);
		return mav;
	}
	
	@RequestMapping("/updateOrder_food") 
	public ModelAndView updateOrder_food(Order_food of){
		order_foodService.updateOrder_food(of);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../order_food/selectAll");
		return mav;
	}

	@RequestMapping("/deleteOrder_food") 
	public ModelAndView deleteOrder_food(int ofid){
		order_foodService.deleteOrder_food(ofid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../order_food/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyOrder_food")
	public ModelAndView deleteManyOrder_food(String str){
		int ofid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				ofid= Integer.valueOf(temp).intValue();
				order_foodService.deleteOrder_food(ofid);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../order_food/selectAll");
		return mav;
	}
}
