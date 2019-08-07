package com.digital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.Shopping_trolleyInfo;
import com.digital.pojo.Shopping_trolleyInfoAdd;
import com.digital.pojo.Shopping_trolley_food;
import com.digital.service.RestaurantInfoService;
import com.digital.service.Shopping_trolleyInfoAddService;
import com.digital.service.Shopping_trolleyInfoService;
import com.digital.service.Shopping_trolley_foodService;

@RequestMapping("/shopping_trolleyInfoAdd") 
@Controller//��ʶ��һ��������
public class Shopping_trolleyInfoAddController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
    private Shopping_trolleyInfoAddService shopping_trolleyInfoAddService;
	@Autowired
    private Shopping_trolley_foodService shopping_trolley_foodService;
	@Autowired
    private Shopping_trolleyInfoService shopping_trolleyInfoService;
	
	//ֻ��Ҫ���в�ѯ����
	@RequestMapping("/visitShopping_trolley")
	public ModelAndView visitShopping_trolley(HttpSession session, int rid){ 
		int uid= (Integer) session.getAttribute("uid");
		Shopping_trolleyInfo sti1 = new Shopping_trolleyInfo();//sti1ֻ�������洢uid��rid��
		sti1.setRid(rid);
		sti1.setUid(uid);
		Shopping_trolleyInfo sti= shopping_trolleyInfoService.getSidByUidAndRid(sti1);//���ﳵģ��д���Ͳ�����ֲ�ѯ���������
		List<Shopping_trolley_food> stfList= shopping_trolley_foodService.getShopping_trolley_foodList(sti.getSid());
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);

		int star=getStar(restaurant.getRstar());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/shopping_trolley");
		mav.addObject("sti", sti);
		mav.addObject("star", star);
		mav.addObject("stfList", stfList);
		mav.addObject("restaurant", restaurant);
		return mav;
	}

	//Ϊ����ʾ�͹ݵ��Ǽ�
	public int getStar(float rstar){
		int star= (int)rstar;
//		System.out.println("�͹��Ǽ�Ϊ"+star);
		return star;
	}
	
}
