package com.digital.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.Evaluation;
import com.digital.pojo.EvaluationNum;
import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.OrderInfo;
import com.digital.pojo.Order_food;
import com.digital.pojo.Page_Evaluation;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.UserInfo;
import com.digital.service.EvaluationService;
import com.digital.service.FoodInfoService;
import com.digital.service.OrderInfoService;
import com.digital.service.Order_foodService;
import com.digital.service.RestaurantInfoService;
import com.digital.service.UserInfoService;


@RequestMapping("/evaluation") 
@Controller//标识是一个控制器
public class EvaluationController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
    private EvaluationService evaluationService;
	@Autowired
    private OrderInfoService orderInfoService;
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
    private Order_foodService order_foodService;
	@Autowired
    private FoodInfoService foodInfoService;
	
	public Page_Evaluation page_Evaluation;

	@RequestMapping("/visitEvaluation") 
	public ModelAndView visitEvaluation(int rid){
		List<Evaluation> evaluationList= evaluationService.getEvaluationByRid(rid);
		//对username和all_food做一些变化
		for(int i=0; i<evaluationList.size(); i++){
			String name= new String();
			if(evaluationList.get(i).getAnonymous()==0){
				name= evaluationList.get(i).getUsername().substring(0, 1);
				name+= "*********";
			}
			else{
				name= "匿名评价";
			}
			evaluationList.get(i).setUsername(name);
			String all_food= new String();
			if(evaluationList.get(i).getIs_recommend()==1){//同意推荐评论
				for(int j=0; j<evaluationList.get(i).getAll_food().length(); j++){
					if(evaluationList.get(i).getAll_food().charAt(j)!='+'){
						all_food+= evaluationList.get(i).getAll_food().charAt(j);
					}
				}
			}
			evaluationList.get(i).setAll_food(all_food);
		}
		
		//以下是Pagination的各种变量
		int pageId=1;
		page_Evaluation= new Page_Evaluation();
		page_Evaluation.setPageSize(10);//10表示每页要显示10条评论
		page_Evaluation.setPageId(pageId);
		page_Evaluation.setFirstThing(1-1);
		page_Evaluation.setAllEvaluation(evaluationList);
		page_Evaluation.setThingNum(page_Evaluation.getAllEvaluation().size());
		//求总页数
		if(page_Evaluation.getThingNum()% page_Evaluation.getPageSize()==0)
			page_Evaluation.setPageNum(page_Evaluation.getThingNum()/ page_Evaluation.getPageSize());
		else
			page_Evaluation.setPageNum((page_Evaluation.getThingNum()/ page_Evaluation.getPageSize())+1);
		//如果只有一页，则该页显示的评论数量要少于规定的数量
		if(page_Evaluation.getPageId()==page_Evaluation.getPageNum())
			page_Evaluation.setPageNowSize(page_Evaluation.getThingNum()-((page_Evaluation.getPageId()-1)*page_Evaluation.getPageSize()));
		else
			page_Evaluation.setPageNowSize(page_Evaluation.getPageSize());
		List<Evaluation> NowEvaluation = new ArrayList<Evaluation>();
		for(int i=0;i<page_Evaluation.getPageNowSize();i++)
		{
			if(page_Evaluation.getAllEvaluation().size()>0)
				NowEvaluation.add(i, page_Evaluation.getAllEvaluation().get(page_Evaluation.getFirstThing()+i));
		}
		page_Evaluation.setNowEvaluation(NowEvaluation);
		
		//更新evaluationNum，统计餐馆的评论，并生成评论页面的统计表要用的数据
		EvaluationNum evaluationNum= updateEvaluationNum(rid);
		
		//restaurant_header.jsp文件有用到的参数
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		int star= (int)restaurant.getRstar();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/evaluation");
		mav.addObject("star", star);
//		System.out.println("星级为"+star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("evaluationList", page_Evaluation.getNowEvaluation());
		mav.addObject("pageNum", page_Evaluation.getPageNum());
		mav.addObject("pageId", page_Evaluation.getPageId());
		mav.addObject("evaluationNum", evaluationNum);
		return mav;
	}

	@RequestMapping("/jumpToEvaluate") 
	public ModelAndView jumpToEvaluate(int oid){
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo oi= oiList.get(0);
		//restaurant_header.jsp文件有用到的参数
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(oi.getRid());
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		int star= (int)restaurant.getRstar();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/evaluate");
		mav.addObject("oid", oi.getOid());
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		return mav;
	}

	@RequestMapping("/evaluate") 
	public ModelAndView evaluate(int oid, Evaluation evaluation){
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo order= oiList.get(0);
		UserInfo user= userInfoService.getUserInfoByUid(order.getUid());
		String username= user.getUsername();
		evaluation.setUsername(username);
		Date date= new Date();
		String edate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		evaluation.setEdate(edate);
		evaluation.setAll_food(order.getAll_food());
		evaluation.setUid(order.getUid());
		evaluation.setRid(order.getRid());
		evaluationService.addEvaluation(evaluation);
		orderInfoService.evaluate(oid);//修改订单状态
		
		//如果用户允许推荐菜品，那么就修改food的great参数
//		System.out.println("用户是否推荐："+evaluation.getIs_recommend());
		if(evaluation.getIs_recommend()==1){
			int fid=0;
			List<Integer> fidList= order_foodService.getFidByOid(oid);
			for(int i=0; i<fidList.size(); i++){
				fid= fidList.get(i);
//				System.out.println("菜品ID为："+fid);
				List<FoodInfo> foodList= foodInfoService.getFoodInfoByFid(fid);
				FoodInfo food= foodList.get(0);
//				System.out.println("菜品点赞数为："+food.getGreat());
				food.setGreat(food.getGreat()+1);
//				System.out.println("菜品点赞数为："+food.getGreat());
				foodInfoService.addGreat(food);//增加菜品的推荐数（即赞数）
			}
		}
		
		EvaluationNum evaluationNum= updateEvaluationNum(order.getRid());
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant.setRid(order.getRid());
		restaurant.setRstar(evaluationNum.getRstar());
		restaurantInfoService.updateRstar(restaurant);//更新餐馆的星级

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../evaluation/visitEvaluation?rid="+order.getRid());
		return mav;
	}

	@RequestMapping("/pageEvaluation") 
	public ModelAndView pageEvaluation(int pageId, int rid){
		ModelAndView mav = new ModelAndView();
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		page(pageId);
		int star= (int)restaurant.getRstar();
		mav.setViewName("jsp/evaluation");
		mav.addObject("star", star);
		mav.addObject("restaurant", restaurant);
		mav.addObject("evaluationList", page_Evaluation.getNowEvaluation());
		mav.addObject("pageNum", page_Evaluation.getPageNum());
		mav.addObject("pageId", page_Evaluation.getPageId());
		return mav;
	}
	
	private void page(int pageId)
	{
		page_Evaluation.setThingNum(page_Evaluation.getAllEvaluation().size());
		//求总页数
		if(page_Evaluation.getThingNum()% page_Evaluation.getPageSize()==0)
			page_Evaluation.setPageNum(page_Evaluation.getThingNum()/ page_Evaluation.getPageSize());
		else
			page_Evaluation.setPageNum((page_Evaluation.getThingNum()/ page_Evaluation.getPageSize())+1);
		page_Evaluation.setPageId(pageId);
		page_Evaluation.setFirstThing((page_Evaluation.getPageId()-1)*page_Evaluation.getPageSize());
		if(page_Evaluation.getPageId()==page_Evaluation.getPageNum())//最后一页
			page_Evaluation.setPageNowSize(page_Evaluation.getThingNum()-((page_Evaluation.getPageId()-1)*page_Evaluation.getPageSize()));
		else
			page_Evaluation.setPageNowSize(page_Evaluation.getPageSize());
		List<Evaluation> NowEvaluation = new ArrayList<Evaluation>();
		for(int i=0;i<page_Evaluation.getPageNowSize();i++)
		{
			if(page_Evaluation.getAllEvaluation().size()>0)
				NowEvaluation.add(i, page_Evaluation.getAllEvaluation().get(page_Evaluation.getFirstThing()+i));
		}
		page_Evaluation.setNowEvaluation(NowEvaluation);
	}

	//更新EvaluationNum,并且可以统计餐馆的评论和更新餐馆的星级
	private EvaluationNum updateEvaluationNum(int rid){
		EvaluationNum evaluationNum= new EvaluationNum();
		List<Evaluation> evaluationList= evaluationService.getEvaluationByRid(rid);
		float score=0;
		evaluationNum.setEvaluationList(evaluationList);
		for(int i=0; i<evaluationList.size(); i++){
			if(evaluationList.get(i).getEstar()==1)
				evaluationNum.setOne(evaluationNum.getOne()+1);
			else if(evaluationList.get(i).getEstar()==2)
				evaluationNum.setTwo(evaluationNum.getTwo()+1);
			else if(evaluationList.get(i).getEstar()==3)
				evaluationNum.setThree(evaluationNum.getThree()+1);
			else if(evaluationList.get(i).getEstar()==4)
				evaluationNum.setFour(evaluationNum.getFour()+1);
			else//5星
				evaluationNum.setFive(evaluationNum.getFive()+1);
			score+= evaluationList.get(i).getEstar();
		}
		evaluationNum.setSum(evaluationList.size());
		float rstar= score/evaluationNum.getSum();
		evaluationNum.setRstar(rstar);
		return evaluationNum;
	}

	//后台
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")==null)
		{
			List<Evaluation> evaluationList= evaluationService.getAllEvaluation();
			mav.addObject("evaluationList", evaluationList);
		}
		else{
			int rid= (Integer) session.getAttribute("rid");
			List<Evaluation> evaluationList= evaluationService.getEvaluationByRid(rid);
			mav.addObject("evaluationList", evaluationList);
		}
		mav.setViewName("houtai/evaluation-list");
		return mav;
	}
	
	@RequestMapping("/selectByEid") 
	public ModelAndView selectByEid(String eid1, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int eid=0;
		if(eid1.length()!=0){
			eid= Integer.valueOf(eid1).intValue();	
		}
		if(session.getAttribute("rid")==null)
		{
			List<Evaluation> evaluationList = evaluationService.getEvaluationByEid(eid);
			mav.addObject("evaluationList", evaluationList);
		}
		else{
			ForSearchOfRid fe= new ForSearchOfRid();
			int rid= (Integer) session.getAttribute("rid");
			fe.setRid(rid);
			fe.setEid(eid);
			List<Evaluation> evaluationList = evaluationService.getEvaluationByEidOfRid(fe);
			mav.addObject("evaluationList", evaluationList);
		}
		mav.setViewName("houtai/evaluation-list");
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/evaluation-add");
		return mav;
	}
	
	@RequestMapping("/addEvaluation") 
	public ModelAndView addEvaluation(Evaluation en){
		evaluationService.addEvaluation(en);
//		System.out.println("要添加的评论是"+ en.toString());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../evaluation/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int eid){
		List<Evaluation> evaluationList = evaluationService.getEvaluationByEid(eid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/evaluation-upd");
		mav.addObject("evaluationList", evaluationList);
		return mav;
	}

	@RequestMapping("/updateEvaluation") 
	public ModelAndView updateEvaluation(Evaluation en){
		evaluationService.updateEvaluation(en);
//		System.out.println("要修改的订单是"+ en.toString());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../evaluation/selectAll");
		return mav;
	}

	@RequestMapping("/deleteEvaluation") 
	public ModelAndView deleteEvaluation(int eid){
		evaluationService.deleteEvaluation(eid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../evaluation/selectAll");
		return mav;
	}

	@RequestMapping("/deleteManyEvaluation")
	public ModelAndView deleteManyEvaluation(String str){
		int eid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				eid= Integer.valueOf(temp).intValue();
				evaluationService.deleteEvaluation(eid);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../evaluation/selectAll");
		return mav;
	}	
}
