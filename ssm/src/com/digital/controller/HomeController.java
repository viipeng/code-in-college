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
@Controller//��ʶ��һ��������
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

    //���һЩ�������Եĳ�ʼ������pagiantion������
    public void Initialize() {
		int pageSize=6;//6��ʾÿҳ��ʾ6���͹�
		page_Restaurant.setPageSize(pageSize);
		page_Restaurant.setPageId(1);
		page_Restaurant.setFirstThing(1-1);
		page_Restaurant.setThingNum(restaurantInfoService.selectRestaurantNum());
		//����ҳ��
		if(page_Restaurant.getThingNum()% page_Restaurant.getPageSize()==0)
			page_Restaurant.setPageNum(page_Restaurant.getThingNum()/ page_Restaurant.getPageSize());
		else
			page_Restaurant.setPageNum((page_Restaurant.getThingNum()/ page_Restaurant.getPageSize())+1);
    }
  
    //��վ��ڣ�Ҳ�ǲ͹ݵ�Ĭ������
	@RequestMapping("/visit") 
	public ModelAndView visit(HttpSession session)
	{
//		pagination= new Pagination();
		page_Restaurant= new Page_Restaurant();
		ModelAndView mav = new ModelAndView();
		Initialize();
		
		session.setAttribute("isSearch", 1);//������ʾ�������̼ҡ��͡������̼ҵ����������
		//���ֻ��һҳ�����ҳ��ʾ�Ĳ͹�����Ҫ���ڹ涨������
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
		
		//�����û�λ�����Ʋ͹ݱ��minute,distance����restaurantInfoService
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
				distance= (float) (Math.sqrt(a)*0.25);//��λΪǧ��
				int temp= (int)(distance*10);
				distance= (float) (temp/10.0);
//				System.out.println("����Ϊ��"+distance);
				minute = (int) (page_Restaurant.getAllRestaurant().get(i).getRprepare_time()+
						((distance*1000)/page_Restaurant.getAllRestaurant().get(i).getRvelocity()));
//				System.out.println("ʱ��Ϊ��"+minute);
				page_Restaurant.getAllRestaurant().get(i).setDistance(distance);
				page_Restaurant.getAllRestaurant().get(i).setMinute(minute);
				restaurantInfoService.updateDisAndMin(page_Restaurant.getAllRestaurant().get(i));
			}
			//Ϊ�˷�ֹ��ҳ�͹���ʾ����ʱ���ֺܶ�С��
			page_Restaurant.setAllRestaurant(restaurantInfoService.getRestaurantInfo());
		}
		
		//�Ƽ��͹�
		List<RestaurantInfo> rrestaurantList = new ArrayList<RestaurantInfo>();
		rrestaurantList= restaurantInfoService.getRrestaurantInfo();

		mav.setViewName("jsp/homepage");
		mav.addObject("rrestaurantList", rrestaurantList);
		mav.addObject("restaurantList", page_Restaurant.getNowRestaurant());
		mav.addObject("pageNum", page_Restaurant.getPageNum());
		mav.addObject("pageId", page_Restaurant.getPageId());
		
		return mav;
	}

	//��ҳ���������ܣ���Ϊ�����ù��ܻᵼ��pagiantion�еĺܶ����Ի�仯����Ȼ����ֺܶ�����
	@RequestMapping("/searchRestaurant")
	public ModelAndView searchRestaurant(String name, HttpSession session)
	{
		name='%'+name+'%';
		ModelAndView mav = new ModelAndView();
		if(!restaurantInfoService.searchRestaurant(name).isEmpty())
		{
			page_Restaurant.setAllRestaurant(restaurantInfoService.searchRestaurant(name));
			page_Restaurant.setThingNum(page_Restaurant.getAllRestaurant().size());//�޸��ܲ͹���
			//�޸���ҳ��
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
			JOptionPane.showMessageDialog(null, "�͹ݲ���ʧ�ܣ�û����Ҳ͹�", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
			mav.setViewName("redirect:../home/visit");
		}
		return mav;
	}
	
	//�л���ָ��ҳ���͹���η�������ν
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

	//��ʱ������͹�
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
	
	//����������͹�
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

	//�����ͼ�����͹�
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

	//�����ͷ�����͹�
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

	//���˾����Ѹߵ�������͹�
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

	//���˾����ѵ͵�������͹�
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

	//����������͹�
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

	//����������͹�
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
	
	//�л�����һҳҪ�õķ���
	//���в͹ݵķ��඼ֻ���޸�pagination�е�AllRestaurant����ѯ�������в͹ݣ�����
	//����ķ����Ĺ������޸�pagination�е�NowRestaurant����ǰҳҪ��ʾ�Ĳ͹ݣ��Ѿ�����pagination������
	private void page(int pageId)
	{
		page_Restaurant.setPageId(pageId);
		page_Restaurant.setFirstThing((page_Restaurant.getPageId()-1)*page_Restaurant.getPageSize());
		if(page_Restaurant.getPageId()==page_Restaurant.getPageNum())//���һҳ
			page_Restaurant.setPageNowSize(page_Restaurant.getThingNum()-((page_Restaurant.getPageId()-1)*page_Restaurant.getPageSize()));
		else
			page_Restaurant.setPageNowSize(page_Restaurant.getPageSize());
		List<RestaurantInfo> NowRestaurant = new ArrayList<RestaurantInfo>();
		for(int i=0;i<page_Restaurant.getPageNowSize();i++)
		{
//			System.out.println("��ǰҳҪ��ʾ�Ĳ͹���Ϊ��"+page_Restaurant.getPageNowSize());
			if(page_Restaurant.getAllRestaurant().size()>0)
				NowRestaurant.add(i, page_Restaurant.getAllRestaurant().get(page_Restaurant.getFirstThing()+i));
		}
		page_Restaurant.setNowRestaurant(NowRestaurant);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {  
		ModelAndView mav= new ModelAndView();
		//�������֮ǰҳ��Ĺ����Ѿ�ʵ����
	    //��session�б�������¼֮ǰ��ҳ��  
	    HttpSession session = request.getSession();
	    //�����¼ǰ��ҳ�� ��ȡ��������ܣ���Ϊ�ᵼ�´�Logoutҳ������¼�ᵼ�µ�½ʧ��
	    session.setAttribute("previousUrl", request.getHeader("referer"));
//	    System.out.println("URL��"+session.getAttribute("previousUrl"));
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
		//��ո��û������й��ﳵ��ɾ�����ݿ��и��û��Ĺ��ﳵ�е�foodSum��total��Ϣ,�Լ�shopping_trolley_food�е�����
		int uid= (Integer) session.getAttribute("uid");
		shopping_trolleyInfoService.DeleteSTOfUid(uid);//��shopping_trolley���е��û�������0
		List<Integer> sidList= new ArrayList<Integer>();
		sidList= shopping_trolleyInfoService.getSidByUid(uid);
		int sid=0;
		for(int i=0; i<sidList.size(); i++){
			sid= sidList.get(i);
			shopping_trolley_foodService.DeleteSTFBySid(sid);//ɾ��shopping_trolley_food���е�����
		}
		session.removeAttribute("uid");
//		System.out.println("��"+pageId+"��");
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


