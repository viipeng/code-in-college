package com.digital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.Page_Restaurant;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.UserInfo;
import com.digital.service.RestaurantInfoService;
import com.digital.service.Shopping_trolleyInfoService;
import com.digital.service.Shopping_trolley_foodService;
import com.digital.service.UserInfoService;

import java.io.IOException;
import java.lang.Math;


@RequestMapping("/home") 
@Controller//标识是一个控制器
public class HomeController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;	
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
    private Shopping_trolleyInfoService shopping_trolleyInfoService;
	@Autowired
    private Shopping_trolley_foodService shopping_trolley_foodService;
	
//    public Pagination pagination; 
    public Page_Restaurant page_Restaurant;

    //完成一些公共属性的初始化，鸡pagiantion的属性
    public void Initialize() {
		int pageSize=6;//6表示每页显示6个餐馆
		page_Restaurant.setPageSize(pageSize);
		page_Restaurant.setPageId(1);
		page_Restaurant.setFirstThing(1-1);
		page_Restaurant.setThingNum(restaurantInfoService.selectRestaurantNum());
		//求总页数
		if(page_Restaurant.getThingNum()% page_Restaurant.getPageSize()==0)
			page_Restaurant.setPageNum(page_Restaurant.getThingNum()/ page_Restaurant.getPageSize());
		else
			page_Restaurant.setPageNum((page_Restaurant.getThingNum()/ page_Restaurant.getPageSize())+1);
    }
  
    //网站入口，也是餐馆的默认排序
	@RequestMapping("/visit") 
	public ModelAndView visit(HttpSession session)
	{
//		pagination= new Pagination();
		page_Restaurant= new Page_Restaurant();
		ModelAndView mav = new ModelAndView();
		Initialize();
		
		session.setAttribute("isSearch", 1);//用来显示“附近商家”和“附近商家的搜索结果”
		//如果只有一页，则该页显示的餐馆数量要少于规定的数量
		if(page_Restaurant.getPageId()==page_Restaurant.getPageNum())
			page_Restaurant.setPageNowSize(page_Restaurant.getThingNum()-((page_Restaurant.getPageId()-1)*page_Restaurant.getPageSize()));
		else
			page_Restaurant.setPageNowSize(page_Restaurant.getPageSize());		
		page_Restaurant.setAllRestaurant(restaurantInfoService.getRestaurantInfo());
		List<RestaurantInfo> NowRestaurant = new ArrayList<RestaurantInfo>();
		for(int i=0;i<page_Restaurant.getPageNowSize();i++)
		{
			NowRestaurant.add(i, page_Restaurant.getAllRestaurant().get(page_Restaurant.getFirstThing()+i));
		}
		page_Restaurant.setNowRestaurant(NowRestaurant);
		
		//根据用户位置完善餐馆表的minute,distance属性restaurantInfoService
		if( session.getAttribute("uid")!=null)
		{
			int minute=0;
			float distance=0;
			int uid= (Integer) session.getAttribute("uid");
			UserInfo ui= userInfoService.getUserInfoByUid(uid);
			for(int i=0;i<page_Restaurant.getAllRestaurant().size();i++)
			{
				int x= Math.abs(ui.getUx_coordinate()-page_Restaurant.getAllRestaurant().get(i).getRx_coordinate());
				int y= Math.abs(ui.getUy_coordinate()-page_Restaurant.getAllRestaurant().get(i).getRy_coordinate());
				int a= (int) Math.abs(Math.pow(x, 2)+Math.pow(y, 2));
				distance= (float) (Math.sqrt(a)*0.25);//单位为千米
				int temp= (int)(distance*10);
				distance= (float) (temp/10.0);
//				System.out.println("距离为："+distance);
				minute = (int) (page_Restaurant.getAllRestaurant().get(i).getRprepare_time()+
						((distance*1000)/page_Restaurant.getAllRestaurant().get(i).getRvelocity()));
//				System.out.println("时间为："+minute);
				page_Restaurant.getAllRestaurant().get(i).setDistance(distance);
				page_Restaurant.getAllRestaurant().get(i).setMinute(minute);
				restaurantInfoService.updateDisAndMin(page_Restaurant.getAllRestaurant().get(i));
			}
			//为了防止首页餐馆显示距离时出现很多小数
			page_Restaurant.setAllRestaurant(restaurantInfoService.getRestaurantInfo());
		}
		
		//推荐餐馆
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();

		mav.setViewName("jsp/homepage");
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		
		return mav;
	}

	//主页的搜索功能，因为启动该功能会导致pagiantion中的很多属性会变化，不然会出现很多问题
	@RequestMapping("/searchRestaurant")
	public ModelAndView searchRestaurant(String name, HttpSession session)
	{
		name='%'+name+'%';
		ModelAndView mav = new ModelAndView();
		if(!restaurantInfoService.searchRestaurant(name).isEmpty())
		{
			page_Restaurant.setAllRestaurant(restaurantInfoService.searchRestaurant(name));
			page_Restaurant.setThingNum(page_Restaurant.getAllRestaurant().size());//修改总餐馆数
			//修改总页数
			if(page_Restaurant.getAllRestaurant().size()% page_Restaurant.getPageSize()==0)
				page_Restaurant.setPageNum(page_Restaurant.getAllRestaurant().size()/ page_Restaurant.getPageSize());
			else
				page_Restaurant.setPageNum((page_Restaurant.getAllRestaurant().size()/ page_Restaurant.getPageSize())+1);
			page(1);
			

			
			List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
			rrestaurantList= restaurantInfoService.getRrestaurantInfo();
			mav.addObject("rrestaurantList", rrestaurantList);
			mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
			mav.addObject("pageNum", page_Restaurant.getPageNum());
			mav.addObject("pageId", page_Restaurant.getPageId());
			session.setAttribute("isSearch", 2);
			mav.setViewName("jsp/homepage");
		}
		else{
			JOptionPane.showMessageDialog(null, "餐馆查找失败，没有这家餐馆", "查找结果", JOptionPane.PLAIN_MESSAGE);
			mav.setViewName("redirect:../home/visit");
		}
		return mav;
	}
	
	//切换到指定页，餐馆如何分类无所谓
	@RequestMapping("/pageRestaurant") 
	public ModelAndView pageRestaurant(int pageId, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		page(pageId);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按时间排序餐馆
	@RequestMapping("/selectByMinute")//, method=RequestMethod.GET
	public ModelAndView selectByMinute(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByMinute());
		page(1);
		
		/*JSONArray jsonArray = JSONArray.fromObject(page_Restaurant.getNowRestaurant());
		String json = jsonArray.toString();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);*/
		
		/*response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("restaurant_list.jsp").forward(request, response);*/
		
		mav.setViewName("jsp/homepage");
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}
	
	//按评分排序餐馆
	@RequestMapping("/selectByStar")
	public ModelAndView selectByStar(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByStar());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按起送价排序餐馆
	@RequestMapping("/selectBySending_fee")
	public ModelAndView selectBySending_fee(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectBySending_fee());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按配送费排序餐馆
	@RequestMapping("/selectByShipping_fee")
	public ModelAndView selectByShipping_fee(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByShipping_fee());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按人均消费高到低排序餐馆
	@RequestMapping("/selectByCpc")
	public ModelAndView selectByCpc(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByCpc());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按人均消费低到高排序餐馆
	@RequestMapping("/selectByCpc1")
	public ModelAndView selectByCpc1(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByCpc1());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按销量排序餐馆
	@RequestMapping("/selectBySales_volume")
	public ModelAndView selectBySales_volume(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectBySales_volume());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}

	//按距离排序餐馆
	@RequestMapping("/selectByDistance")
	public ModelAndView selectByDistance(HttpSession session){
		ModelAndView mav = new ModelAndView();
		page_Restaurant.setAllRestaurant(restaurantInfoService.selectByDistance());
		page(1);
		
		mav.setViewName("jsp/homepage");
		
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		return mav;
	}
	
	//切换到下一页要用的方法
	//所有餐馆的分类都只是修改pagination中的AllRestaurant（查询到的所有餐馆）而已
	//下面的方法的功能是修改pagination中的NowRestaurant（当前页要显示的餐馆）已经其他pagination的属性
	private void page(int pageId)
	{
		page_Restaurant.setPageId(pageId);
		page_Restaurant.setFirstThing((page_Restaurant.getPageId()-1)*page_Restaurant.getPageSize());
		if(page_Restaurant.getPageId()==page_Restaurant.getPageNum())//最后一页
			page_Restaurant.setPageNowSize(page_Restaurant.getThingNum()-((page_Restaurant.getPageId()-1)*page_Restaurant.getPageSize()));
		else
			page_Restaurant.setPageNowSize(page_Restaurant.getPageSize());
		List<RestaurantInfo> NowRestaurant = new ArrayList<RestaurantInfo>();
		for(int i=0;i<page_Restaurant.getPageNowSize();i++)
		{
//			System.out.println("当前页要显示的餐馆数为："+page_Restaurant.getPageNowSize());
			if(page_Restaurant.getAllRestaurant().size()>0)
				NowRestaurant.add(i, page_Restaurant.getAllRestaurant().get(page_Restaurant.getFirstThing()+i));
		}
		page_Restaurant.setNowRestaurant(NowRestaurant);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {  
		ModelAndView mav= new ModelAndView();
		//这个保存之前页面的功能已经实现了
	    //在session中保存进入登录之前的页面  
	    HttpSession session = request.getSession();
	    //保存登录前的页面 （取消这个功能，因为会导致从Logout页面点击登录会导致登陆失败
	    session.setAttribute("previousUrl", request.getHeader("referer"));
//	    System.out.println("URL是"+session.getAttribute("previousUrl"));
		mav.setViewName("jsp/login");
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {  
		ModelAndView mav= new ModelAndView();
//		HttpSession session = request.getSession();
//		session.setAttribute("userExist", "0");
		mav.setViewName("jsp/register");
		return mav;
	}

	@RequestMapping("/logout") 
	public ModelAndView logout(HttpSession session)//, int pageId
	{
		ModelAndView mav = new ModelAndView();
		//清空该用户的所有购物车，删除数据库中该用户的购物车中的foodSum和total信息,以及shopping_trolley_food中的数据
		int uid= (Integer) session.getAttribute("uid");
		shopping_trolleyInfoService.DeleteSTOfUid(uid);//把shopping_trolley表中的用户数据置0
		List<Integer> sidList= new ArrayList<Integer>();
		sidList= shopping_trolleyInfoService.getSidByUid(uid);
		int sid=0;
		for(int i=0; i<sidList.size(); i++){
			sid= sidList.get(i);
			shopping_trolley_foodService.DeleteSTFBySid(sid);//删除shopping_trolley_food表中的数据
		}
		session.removeAttribute("uid");
//		System.out.println("第"+pageId+"第");
//		page(pageId);
		mav.setViewName("redirect:../home/visit");
		return mav;
	}

	@RequestMapping("/bossLogin")
	public ModelAndView bossLogin(HttpServletRequest request) {  
		ModelAndView mav= new ModelAndView();
		mav.setViewName("houtai/login");
		return mav;
	}

	@RequestMapping("/merchantLogin")
	public ModelAndView merchantLogin(HttpServletRequest request) {  
		ModelAndView mav= new ModelAndView();
		mav.setViewName("jsp/merchant_login");
		return mav;
	}

	@RequestMapping("/merchantLogout") 
	public ModelAndView merchantLogout(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("rid");
		mav.setViewName("redirect:../home/visit");
		return mav;
	}

	
}


