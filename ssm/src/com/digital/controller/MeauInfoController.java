package com.digital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.MeauInfo;
import com.digital.service.MeauInfoService;



@RequestMapping("/meauInfo") 
@Controller//标识是一个控制器
public class MeauInfoController {

	@Autowired
    private MeauInfoService meauInfoService;

	@RequestMapping("/select")
	public ModelAndView select(int uid)
	{
		List<MeauInfo> miaList= meauInfoService.getMeauInfo();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/homepage");
		mav.addObject("miaList", miaList);
		mav.addObject("uid", uid);
		return mav;
	}
	
	//后台
	@RequestMapping("/selectByMid") 
	public ModelAndView selectByMid(String mid1, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int mid=0;
		if(mid1.length()!=0){
			mid= Integer.valueOf(mid1).intValue();	
		}
		if(session.getAttribute("rid")==null)
		{
			List<MeauInfo> meauList = meauInfoService.getMeauInfoBymid(mid);
			mav.addObject("meauList", meauList);
		}
		else{
			ForSearchOfRid fe= new ForSearchOfRid();
			int rid= (Integer) session.getAttribute("rid");
			fe.setRid(rid);
			fe.setMid(mid);
			List<MeauInfo> meauList = meauInfoService.getMeauInfoBymidOfRid(fe);
			mav.addObject("meauList", meauList);
		}
		mav.setViewName("houtai/meau-list");
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")==null)
		{
			List<MeauInfo> meauList = meauInfoService.getMeauInfo();
			mav.addObject("meauList", meauList);
		}
		else{
			int rid= (Integer) session.getAttribute("rid");
			List<MeauInfo> meauList = meauInfoService.getMeauInfoByrid(rid);
			mav.addObject("meauList", meauList);
		}
		mav.setViewName("houtai/meau-list");
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/meau-add");
		return mav;
	}
	
	@RequestMapping("/addMeau") 
	public ModelAndView addMeau(MeauInfo meau){
		meauInfoService.addMeauInfo(meau);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../meauInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int mid){
		List<MeauInfo> meauList = meauInfoService.getMeauInfoBymid(mid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/meau-upd");
		mav.addObject("meauList", meauList);
		return mav;
	}
	
	@RequestMapping("/updateMeau") 
	public ModelAndView updateMeau(MeauInfo mia){
		meauInfoService.updateMeauInfo(mia);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../meauInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteMeau") 
	public ModelAndView deleteMeau(int mid){
		meauInfoService.deleteMeauInfo(mid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../meauInfo/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyMeau")
	public ModelAndView deleteManyMeau(String str){
		int mid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				mid= Integer.valueOf(temp).intValue();
				meauInfoService.deleteMeauInfo(mid);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../meauInfo/selectAll");
		return mav;
	}
}
