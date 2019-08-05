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
@Controller//��ʶ��һ��������
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
	
	//����̼ҽ����̼���Ϣҳ��
	@RequestMapping("/visitRestaurantByRid")
	public ModelAndView visitRestaurantByRid(int rid, HttpSession session){
		session.setAttribute("isSearchFood", 0);//0��ʾû���ڲ��Ҳ�Ʒ
		ModelAndView mav = new ModelAndView();
		
		/*session.setAttribute("sort", "Ĭ������");*/
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
		int pageId=1;
		
		//������Pagination�ĸ��ֱ���
//		pagination= new Pagination();
		page_Food= new Page_Food();
		page_Food.setPageSize(6);//6��ʾÿҳҪ��ʾ6����Ʒ
		page_Food.setPageId(pageId);
		page_Food.setFirstThing(1-1);
		int mid= meauInfoList.get(0).getMid();//��øò͹ݵ�һ���˵���ID
		page_Food.setMid(mid);
		page_Food.setAllFood(foodInfoService.getFoodInfoByMid(mid));
		page_Food.setThingNum(page_Food.getAllFood().size());
		//����ҳ��
		if(page_Food.getThingNum()% page_Food.getPageSize()==0)
			page_Food.setPageNum(page_Food.getThingNum()/ page_Food.getPageSize());
		else
			page_Food.setPageNum((page_Food.getThingNum()/ page_Food.getPageSize())+1);
		//���ֻ��һҳ�����ҳ��ʾ�Ĳ�Ʒ����Ҫ���ڹ涨������
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

		//�������û��ڸĲ͹ݵĹ��ﳵ
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			Shopping_trolleyInfo sti1 = new Shopping_trolleyInfo();//sti1ֻ�������洢uid��rid��
			sti1.setRid(rid);
			sti1.setUid(uid);
			sti1.setShipping_fee(restaurant.getShipping_fee());
			Shopping_trolleyInfo sti= shopping_trolleyInfoService.getSidByUidAndRid(sti1);//���ﳵģ��д���Ͳ�����ֲ�ѯ���������
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
	
	//������Ʒ
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
			page_Food.setThingNum(page_Food.getAllFood().size());//�޸��ܲ͹���
			//�޸���ҳ��
			if(page_Food.getAllFood().size()% page_Food.getPageSize()==0)
				page_Food.setPageNum(page_Food.getAllFood().size()/ page_Food.getPageSize());
			else
				page_Food.setPageNum((page_Food.getAllFood().size()/ page_Food.getPageSize())+1);
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
			//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			List<MeauInfo> meauInfoList = meauInfoService.getMeauInfoByrid(rid);
			page_Food.setMid(mid);
			page(pageId);
			int star=getStar(restaurant.getRstar());
			session.setAttribute("isSearchFood", 1);//1��ʾ�ڲ��Ҳ�Ʒ
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
			JOptionPane.showMessageDialog(null, "��Ʒ����ʧ�ܣ�û��������Ʒ", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
			mav.setViewName("redirect:../restaurantInfo/visitRestaurantByRid?rid="+rid);
		}
		return mav;
	}

	//���˵��鿴��Ʒ
	@RequestMapping("/selectByMid")
	public ModelAndView selectByMid(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "Ĭ������");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
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

	//�������鿴��Ʒ
	@RequestMapping("/selectBySales_volume")
	public ModelAndView selectBySales_volume(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "����");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
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

	//���۸��ɵ͵��߲鿴��Ʒ
	@RequestMapping("/selectByPrice")
	public ModelAndView selectByPrice(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "�۸�͵���");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
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

	//���۸��ɸߵ��Ͳ鿴��Ʒ
	@RequestMapping("/selectByPrice1")
	public ModelAndView selectByPrice1(int mid, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int pageId=1;
		/*session.setAttribute("sort", "�۸�ߵ���");*/
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
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

	//�л���ָ��ҳ���˵����ĸ�����ν��ֻ����page()�����޸�PageNowSize����
	@RequestMapping("/pageFood") 
	public ModelAndView pageFood(int pageId, int mid, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		
		int rid = meauInfoService.getRidByMid(mid);
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);//Ϊ��Э�����̨�̼��б����ʾ��getRestaurantInfoByRid�����ķ���������List<RestaurantInfo>
		//��������������Ϊ�˷���ǰ̨�̼ҽ�����������ֻ��һ��Ԫ�ص�restaurantList����restaurant
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

	//��restaurant��ȶ���page_Food.setPageNum()��
	private void page(int pageId)
	{
		page_Food.setThingNum(page_Food.getAllFood().size());
		//����ҳ��
		if(page_Food.getThingNum()% page_Food.getPageSize()==0)
			page_Food.setPageNum(page_Food.getThingNum()/ page_Food.getPageSize());
		else
			page_Food.setPageNum((page_Food.getThingNum()/ page_Food.getPageSize())+1);
		page_Food.setPageId(pageId);
		page_Food.setFirstThing((page_Food.getPageId()-1)*page_Food.getPageSize());
		if(page_Food.getPageId()==page_Food.getPageNum())//���һҳ
			page_Food.setPageNowSize(page_Food.getThingNum()-((page_Food.getPageId()-1)*page_Food.getPageSize()));
		else
			page_Food.setPageNowSize(page_Food.getPageSize());
		List<FoodInfo> NowFood = new ArrayList<FoodInfo>();
		for(int i=0;i<page_Food.getPageNowSize();i++)
		{
//			System.out.println("��ǰҳҪ��ʾ�Ĳ͹���Ϊ��"+page_Food.getPageNowSize());
			if(page_Food.getAllFood().size()>0)
				NowFood.add(i, page_Food.getAllFood().get(page_Food.getFirstThing()+i));
		}
		page_Food.setNowFood(NowFood);
	}

	//Ϊ����ʾ�͹ݵ��Ǽ�
	public int getStar(float rstar){
		int star= (int)rstar;
//		System.out.println("�͹��Ǽ�Ϊ"+star);
		return star;
	}
	
	//��̨
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
