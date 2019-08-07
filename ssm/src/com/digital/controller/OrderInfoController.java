package com.digital.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digital.pojo.Evaluation;
import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.MeauInfo;
import com.digital.pojo.MerchantInfo;
import com.digital.pojo.OrderInfo;
import com.digital.pojo.Order_food;
import com.digital.pojo.Page_Order;
import com.digital.pojo.RestaurantInfo;
import com.digital.pojo.Shopping_trolleyInfo;
import com.digital.pojo.Shopping_trolleyInfoAdd;
import com.digital.pojo.Shopping_trolley_food;
import com.digital.pojo.UserInfo;
import com.digital.service.FoodInfoService;
import com.digital.service.MeauInfoService;
import com.digital.service.MerchantService;
import com.digital.service.OrderInfoService;
import com.digital.service.Order_foodService;
import com.digital.service.RestaurantInfoService;
import com.digital.service.Shopping_trolleyInfoAddService;
import com.digital.service.Shopping_trolleyInfoService;
import com.digital.service.Shopping_trolley_foodService;
import com.digital.service.UserInfoService;

@RequestMapping("/orderInfo") 
@Controller//��ʶ��һ��������
public class OrderInfoController {

	@Autowired
    private RestaurantInfoService restaurantInfoService;
	@Autowired
    private OrderInfoService orderInfoService;
	@Autowired
    private FoodInfoService foodInfoService;
	@Autowired
    private Shopping_trolleyInfoAddService shopping_trolleyInfoAddService;
	@Autowired
    private Shopping_trolley_foodService shopping_trolley_foodService;
	@Autowired
    private Shopping_trolleyInfoService shopping_trolleyInfoService;
	@Autowired
    private Order_foodService order_foodService;
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
    private MeauInfoService meauInfoService;
	@Autowired
    private MerchantService merchantService;


	public Page_Order page_Order;
	
	//�µ�
	@RequestMapping("/ordering")
	public ModelAndView ordering(int sid, HttpSession session)
	{
		List<Shopping_trolleyInfo> stiList= shopping_trolleyInfoService.getSTInfoBySid(sid);
		Shopping_trolleyInfo sti= new Shopping_trolleyInfo();
		sti= stiList.get(0);
		List<Shopping_trolley_food> stfList= shopping_trolley_foodService.getShopping_trolley_foodList(sid);
		
		//����Order�ĸ�������
		OrderInfo oi= new OrderInfo();
		String all_food= new String();
		for(int i=0; i<stfList.size(); i++){
			if(stfList.get(i).getAmount()>1){
				all_food+= "+ "+stfList.get(i).getAmount()+"��"+stfList.get(i).getFname();
			}
			else{
				all_food+= "+ "+ stfList.get(i).getFname();
			}
		}
//		System.out.println("�ö��������²�Ʒ:"+all_food);
		all_food= all_food.substring(2);
//		System.out.println("�ö��������²�Ʒ:"+all_food);
		oi.setAll_food(all_food);
		float consumption= sti.getTotal()+sti.getShipping_fee();
		oi.setConsumption(consumption);
		Date date= new Date();
		String odate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		oi.setOdate(odate);
		oi.setVisible(1);//1��ʾ�ɼ�
		String ostate= "������";
		oi.setOstate(ostate);
		oi.setRid(sti.getRid());
		List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(sti.getRid());
		RestaurantInfo restaurant= new RestaurantInfo();
		restaurant= restaurantList.get(0);
		oi.setRname(restaurant.getRname());
		oi.setRphoto(restaurant.getRphoto());
		int uid= (Integer) session.getAttribute("uid");
		oi.setUid(uid);
		orderInfoService.ordering(oi);
		int oid= orderInfoService.getOid();
//		oi.setOid(oid);
//		List<OrderInfo> orderList = orderInfoService.getOrderInfoByUid(uid);
		/*OrderInfo order= orderInfoService.getOrderInfoByoid(oid);
		List<OrderInfo> orderList = orderInfoService.getOrderInfoByoid(oid);
		OrderInfo order= new OrderInfo();
		order= orderList.get(0);*/
		
		//����order_food��
		for(int i=0; i<stfList.size(); i++){
			Order_food order_food= new Order_food();
			order_food.setAmount(stfList.get(i).getAmount());
			order_food.setFid(stfList.get(i).getFid());
			order_food.setFname(stfList.get(i).getFname());
			order_food.setFphoto(stfList.get(i).getFphoto());
			order_food.setFprice(stfList.get(i).getFprice());
			order_food.setOid(oid);
			order_foodService.addOrder_food(order_food);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/getOrder");
		return mav;
	}
	
	@RequestMapping("/getOrder")
	public ModelAndView getOrder(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		/*List<OrderInfo> oiList = orderInfoService.getOrderInfoByUid(uid);*/
		String state= "ȫ������";
		
		//������Pagination�ĸ��ֱ���
		int pageId=1;
		page_Order= new Page_Order();
		page_Order.setPageSize(4);//4��ʾÿҳҪ��ʾ4������
		page_Order.setPageId(pageId);
		page_Order.setFirstThing(1-1);
		page_Order.setState(state);
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getOrderInfoByUid(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getOrderInfoByRid(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page_Order.setThingNum(page_Order.getAllOrder().size());
		//����ҳ��
		if(page_Order.getThingNum()% page_Order.getPageSize()==0)
			page_Order.setPageNum(page_Order.getThingNum()/ page_Order.getPageSize());
		else
			page_Order.setPageNum((page_Order.getThingNum()/ page_Order.getPageSize())+1);
		//���ֻ��һҳ�����ҳ��ʾ�Ĳ�Ʒ����Ҫ���ڹ涨������
		if(page_Order.getPageId()==page_Order.getPageNum())
			page_Order.setPageNowSize(page_Order.getThingNum()-((page_Order.getPageId()-1)*page_Order.getPageSize()));
		else
			page_Order.setPageNowSize(page_Order.getPageSize());
		List<OrderInfo> NowOrder = new ArrayList<OrderInfo>();
		for(int i=0;i<page_Order.getPageNowSize();i++)
		{
			if(page_Order.getAllOrder().size()>0)
				NowOrder.add(i, page_Order.getAllOrder().get(page_Order.getFirstThing()+i));
		}
		page_Order.setNowOrder(NowOrder);
		
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}

	//��ȡ�����۵Ķ���
	@RequestMapping("/getEOrder")
	public ModelAndView getEOrder(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		int pageId=1;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getEOrderByUid(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getEOrderByRid(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page(pageId);
		String state= "δ���۵Ķ���";
		page_Order.setState(state);
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}

	//��ȡ���ʹ�Ķ���
	@RequestMapping("/getSOrder")
	public ModelAndView getSOrder(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		int pageId=1;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getSOrderByUid(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getSOrderByRid(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page(pageId);
		String state= ";�еĶ���";
		page_Order.setState(state);
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}

	//��ȡ������Ķ���
	@RequestMapping("/getPOrder")
	public ModelAndView getPOrder(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		int pageId=1;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getPOrderByUid(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getPOrderByRid(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page(pageId);
		String state= "δ����Ķ���";
		page_Order.setState(state);
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}

	//��ȡ���˿�Ķ���
	@RequestMapping("/getROrder1")
	public ModelAndView getROrder1(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		int pageId=1;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getROrderByUid1(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getROrderByRid1(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page(pageId);
		String state= "���˿�Ķ���";
		page_Order.setState(state);
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}
	
	//��ȡ���˿�Ķ���
	@RequestMapping("/getROrder2")
	public ModelAndView getROrder2(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		int pageId=1;
		if(session.getAttribute("uid")!=null)
		{
			int uid= (Integer) session.getAttribute("uid");
			page_Order.setAllOrder(orderInfoService.getROrderByUid2(uid));
		}
		if(session.getAttribute("rid")!=null)
		{
			int rid= (Integer) session.getAttribute("rid");
			page_Order.setAllOrder(orderInfoService.getROrderByRid2(rid));
			//restaurant_header.jsp�ļ����õ��Ĳ���
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			RestaurantInfo restaurant= new RestaurantInfo();
			restaurant= restaurantList.get(0);
			int star= (int)restaurant.getRstar();
			mav.addObject("star", star);
			mav.addObject("restaurant", restaurant);
		}
		page(pageId);
		String state= "���˿�Ķ���";
		page_Order.setState(state);
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}
	
	//�л���ָ��ҳ���˵����ĸ�����ν��ֻ����page()�����޸�PageNowSize����
	@RequestMapping("/pageOrder")
	public ModelAndView pageOrder(int pageId, String state)
	{
		page(pageId);
		/*page_Order.setState(state);*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}

	//��restaurant��ȶ���page_Food.setPageNum()��
	private void page(int pageId)
	{
		page_Order.setThingNum(page_Order.getAllOrder().size());
		//����ҳ��
		if(page_Order.getThingNum()% page_Order.getPageSize()==0)
			page_Order.setPageNum(page_Order.getThingNum()/ page_Order.getPageSize());
		else
			page_Order.setPageNum((page_Order.getThingNum()/ page_Order.getPageSize())+1);
		page_Order.setPageId(pageId);
		page_Order.setFirstThing((page_Order.getPageId()-1)*page_Order.getPageSize());
		if(page_Order.getPageId()==page_Order.getPageNum())//���һҳ
			page_Order.setPageNowSize(page_Order.getThingNum()-((page_Order.getPageId()-1)*page_Order.getPageSize()));
		else
			page_Order.setPageNowSize(page_Order.getPageSize());
		List<OrderInfo> NowOrder = new ArrayList<OrderInfo>();
		for(int i=0;i<page_Order.getPageNowSize();i++)
		{
//			System.out.println("��ǰҳҪ��ʾ�Ĳ͹���Ϊ��"+page_Food.getPageNowSize());
			if(page_Order.getAllOrder().size()>0)
				NowOrder.add(i, page_Order.getAllOrder().get(page_Order.getFirstThing()+i));
		}
		page_Order.setNowOrder(NowOrder);
	}
	
	//��תȥǰ̨order.jspҳ��
	/*@RequestMapping("/jump")
	public ModelAndView jump(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/order");
		mav.addObject("state", page_Order.getState());
		mav.addObject("oiList", page_Order.getNowOrder());
		mav.addObject("pageNum", page_Order.getPageNum());
		mav.addObject("pageId", page_Order.getPageId());
		mav.addObject("size", page_Order.getAllOrder().size());
		return mav;
	}*/
	
	//ɾ������
	@RequestMapping("/inVisibleOrder")
	public ModelAndView inVisibleOrder(int oid, HttpServletRequest request){
//		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		orderInfoService.inVisibleOrder(oid);
//		int uid= (Integer) session.getAttribute("uid");
//		page_Order.setAllOrder(orderInfoService.getROrderByUid(uid));
		String url= request.getHeader("referer");
//		System.out.println("ˢ�µ���ַΪ"+url);
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//ȷ���ʹ�
	@RequestMapping("/isSent")
	public ModelAndView isSent(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo order= oiList.get(0);
		orderInfoService.isSent(oid);
		
		//�޸�ʳ����������Ͳ͹ݵ��������Լ��˾����ѣ��Ҳ�û���ж϶����Ƿ���һ������ǰ�Ķ������������ȱ�ݣ�������������������������������������������������������������������������������
		List<Order_food> ofList= order_foodService.getOFListByOid(oid);
//		List<Integer> fidList= order_foodService.getFidByOid(oid);
		RestaurantInfo restaurant= new RestaurantInfo();
		List<OrderInfo> orderList= new ArrayList<OrderInfo>();
		for(int i=0; i<ofList.size(); i++){
			List<FoodInfo> foodList= foodInfoService.getFoodInfoByFid(ofList.get(i).getFid());
			FoodInfo food= foodList.get(0);
			food.setFsales_volume(food.getFsales_volume()+ ofList.get(i).getAmount());
			foodInfoService.updateFsales_volume(food);
			
			int mid= foodInfoService.getMidByFid(ofList.get(i).getFid());
			int rid= meauInfoService.getRidByMid(mid);
			orderList= orderInfoService.getOrderInfoByRid(rid);
			List<RestaurantInfo> restaurantList = restaurantInfoService.getRestaurantInfoByRid(rid);
			restaurant= restaurantList.get(0);
			restaurant.setRsales_volume(restaurant.getRsales_volume()+ ofList.get(i).getAmount());
		}
		float sum=0;
		for(int j=0; j<orderList.size(); j++){
			sum+= orderList.get(j).getConsumption();
		}
		float cpc= sum/orderList.size();
		restaurant.setCpc(cpc);
		
		restaurantInfoService.updateSalesAndCpc(restaurant);//ͬʱ�������������˾�����
		
		
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//ȡ������
	@RequestMapping("/cancelOrder")
	public ModelAndView cancelOrder(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		orderInfoService.deleteOrderInfo(oid);
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//֧������
	@RequestMapping("/payment")
	public ModelAndView payment(int oid, HttpServletRequest request){
		HttpSession session = request.getSession();
		int uid= (Integer) session.getAttribute("uid");
		float account_balance= userInfoService.getAccount_balanceByUid(uid);
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo oi= oiList.get(0);
		if(oi.getConsumption()> account_balance){
			JOptionPane.showMessageDialog(null, "���㣬���ֵ", "֧��֪ͨ", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			UserInfo ui= userInfoService.getUserInfoByUid(uid);
			ui.setAccount_balance(account_balance-oi.getConsumption());
			userInfoService.havePaid(ui);//�޸��û��˺����
			orderInfoService.havePaid(oid);//�޸Ķ���״̬
			JOptionPane.showMessageDialog(null, "֧���ɹ�", "֧��֪ͨ", JOptionPane.PLAIN_MESSAGE);
		}
		ModelAndView mav = new ModelAndView();
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//�����˿�
	@RequestMapping("/appealRefund")
	public ModelAndView appealRefund(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		orderInfoService.appealRefund(oid);
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//ȡ���˿�û��Լ�ȡ�����˿
	@RequestMapping("/cancelRefund")
	public ModelAndView cancelRefund(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		orderInfoService.cancelRefund(oid);
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//ȡ���˿�̼�ͬ���˿
	@RequestMapping("/permitRefund")
	public ModelAndView permitRefund(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
//		HttpSession session = request.getSession();
//		System.out.println("����");
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo oi= oiList.get(0);
		
		//�޸��û��˺����
		int uid= oi.getUid();
		float account_balance= userInfoService.getAccount_balanceByUid(uid);
		UserInfo ui= userInfoService.getUserInfoByUid(uid);
		ui.setAccount_balance(account_balance+oi.getConsumption());
		userInfoService.haveRefund(ui);
		
		//�޸��̼����
		int rid= oi.getRid();
		MerchantInfo merchant= merchantService.getMerchantByRid(rid);
		float mAccount_balance= merchant.getAccount_balance();
		if(mAccount_balance>=oi.getConsumption()){
			merchant.setAccount_balance(mAccount_balance-oi.getConsumption());
//			System.out.println("�̼ҵ����Ϊ��"+merchant.getAccount_balance());
			merchantService.haveRefund(merchant);
			orderInfoService.permitRefund(oid);
			JOptionPane.showMessageDialog(null, "�˿�ɹ�", "�˿�֪ͨ", JOptionPane.PLAIN_MESSAGE);
		}
		else{//����
			JOptionPane.showMessageDialog(null, "���㣬���ֵ", "�˿�֪ͨ", JOptionPane.PLAIN_MESSAGE);
		}
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//ȡ���˿�̼Ҿܾ��˿
	@RequestMapping("/refuseRefund")
	public ModelAndView refuseRefund(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		orderInfoService.refuseRefund(oid);
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}
	
	//�˿���Ӧ����û�õķ�����
	@RequestMapping("/refund")
	public ModelAndView refund(int oid, HttpServletRequest request){
		HttpSession session = request.getSession();
		int uid= (Integer) session.getAttribute("uid");
		float account_balance= userInfoService.getAccount_balanceByUid(uid);
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo oi= oiList.get(0);
		UserInfo ui= userInfoService.getUserInfoByUid(uid);
		ui.setAccount_balance(account_balance+oi.getConsumption());
		userInfoService.haveRefund(ui);//�޸��û��˺����
		orderInfoService.haveRefund(oid);//�޸Ķ���״̬
		JOptionPane.showMessageDialog(null, "�˿�ɹ�", "�˿�֪ͨ", JOptionPane.PLAIN_MESSAGE);
		ModelAndView mav = new ModelAndView();
		String url= request.getHeader("referer");
		mav.setViewName("redirect:"+url);
		return mav;
	}

	//����һ��
	@RequestMapping("/orderingAgain")
	public ModelAndView orderingAgain(int oid, HttpServletRequest request){
		List<OrderInfo> oi1List= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo oi1= oi1List.get(0);
		
		//����Order�ĸ�������
		OrderInfo oi= new OrderInfo();
		oi.setAll_food(oi1.getAll_food());
		oi.setConsumption(oi1.getConsumption());
		Date date= new Date();
		String odate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		oi.setOdate(odate);
		oi.setVisible(1);//1��ʾ�ɼ�
		String ostate= "������";
		oi.setOstate(ostate);
		oi.setRid(oi1.getRid());
		oi.setRname(oi1.getRname());
		oi.setRphoto(oi1.getRphoto());
		oi.setUid(oi1.getUid());
		orderInfoService.ordering(oi);
		int oid1= orderInfoService.getOid();
		
		//����order_food��
		List<Order_food> ofList= order_foodService.getOFListByOid(oid);
		for(int i=0; i<ofList.size(); i++){
			Order_food order_food= new Order_food();
			order_food.setAmount(ofList.get(i).getAmount());
			order_food.setFid(ofList.get(i).getFid());
			order_food.setFname(ofList.get(i).getFname());
			order_food.setFphoto(ofList.get(i).getFphoto());
			order_food.setFprice(ofList.get(i).getFprice());
			order_food.setOid(oid1);
			order_foodService.addOrder_food(order_food);
		}
		
		String url= request.getHeader("referer");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/getOrder");
		return mav;
	}

	//����
	/*@RequestMapping("/evaluate")
	public ModelAndView evaluate(int oid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		List<OrderInfo> oiList= orderInfoService.getOrderInfoByoid(oid);
		OrderInfo order= oiList.get(0);
		orderInfoService.evaluate(oid);//�������Ҫ�����û�д�����������У������ȿ����Ƿ��д���
		mav.setViewName("redirect:../evaluationInfo/evaluate?rid="+ order.getRid());
		return mav;
	}*/

	/*@RequestMapping("/getOrder")
	public ModelAndView getOrder(int uid)
	{
		List<OrderInfo> oiList = orderInfoService.getOrderInfoByUid(uid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/order");
		mav.addObject("oiList", oiList);
		mav.addObject("uid", uid);
		return mav;
	}*/

	@RequestMapping("/addOrder")
	public ModelAndView addOrder(int mid, int uid, int fid)
	{
		orderInfoService.addOrder(uid, fid); 
		List<FoodInfo> fiList = foodInfoService.getFoodInfoByMid(mid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/food");
		mav.addObject("fiList", fiList);
		mav.addObject("mid", mid);
		mav.addObject("uid", uid);
		return mav;
	}
	
	@RequestMapping("/updateOrder")
	public ModelAndView updateOrder(int oid, int uid, String evaluation){
		int evaluation1=0;
		if(evaluation.length()!=0){
			evaluation1= Integer.valueOf(evaluation).intValue();
		}
		orderInfoService.updateOrder(oid, evaluation1);
		List<OrderInfo> oiList = orderInfoService.getOrderInfoByUid(uid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/order");
		mav.addObject("oiList", oiList);
		mav.addObject("uid", uid);
		return mav;
	}

	/*@RequestMapping("/addOrderInShopping_trolley")
	public ModelAndView addOrderInShopping_trolley(int uid, int fid)
	{
		orderInfoService.addOrder(uid, fid);
		List<Shopping_trolleyInfoAdd> stiaList= shopping_trolleyInfoAddService.getShopping_trolleyInfo(uid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/shopping_trolley");
		mav.addObject("stiaList", stiaList);
		mav.addObject("uid", uid);
		return mav;
	}*/
	
	/*@RequestMapping("/addOrderInRankingList")
	public ModelAndView addOrderInRankingList(int mid, int uid, int fid)
	{
		orderInfoService.addOrder(uid, fid);
		List<FoodInfo> rkList = foodInfoService.getRankingList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/ranking_list");
		mav.addObject("rkList", rkList);
		mav.addObject("mid", mid);
		mav.addObject("uid", uid);
		return mav;
	}*/
	
	//��̨
	@RequestMapping("/selectByOid") 
	public ModelAndView selectByOid(String oid1, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int oid=0;
		if(oid1.length()!=0){
			oid= Integer.valueOf(oid1).intValue();	
		}
		if(session.getAttribute("rid")==null)
		{
			List<OrderInfo> oi = orderInfoService.getOrderInfoByoid(oid);
			mav.addObject("oiList", oi);
		}
		else{
			ForSearchOfRid fe= new ForSearchOfRid();
			int rid= (Integer) session.getAttribute("rid");
			fe.setRid(rid);
			fe.setOid(oid);
			List<OrderInfo> oi = orderInfoService.getOrderInfoByoidOfRid(fe);
			mav.addObject("oiList", oi);
		}
		mav.setViewName("houtai/order-list");
		return mav;
	}
	
	@RequestMapping("/selectAll") 
	public ModelAndView selectAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("rid")==null)
		{
			List<OrderInfo> oiList = orderInfoService.getOrderInfo();
			mav.addObject("oiList", oiList);
		}
		else{
			int rid= (Integer) session.getAttribute("rid");
			List<OrderInfo> oiList = orderInfoService.getOrderInfoByRid(rid);
			mav.addObject("oiList", oiList);
		}
		mav.setViewName("houtai/order-list");
		return mav;
	}

	@RequestMapping("/jumpToAdd") 
	public ModelAndView jumpToAdd(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order-add");
		return mav;
	}
	
	@RequestMapping("/addOrderInfo") 
	public ModelAndView addOrderInfo(OrderInfo oi){
		orderInfoService.addOrderInfo(oi);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/selectAll");
		return mav;
	}

	@RequestMapping("/jumpToUpdate") 
	public ModelAndView jumpToUpdate(int oid){
		List<OrderInfo> oi = orderInfoService.getOrderInfoByoid(oid);//getDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("houtai/order-upd");
		mav.addObject("oiList", oi);
		return mav;
	}
	
	@RequestMapping("/updateOrderInfo") 
	public ModelAndView updateOrderInfo(OrderInfo oi){
		orderInfoService.updateOrderInfo(oi);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/selectAll");
		return mav;
	}

	@RequestMapping("/deleteOrder") 
	public ModelAndView deleteOrder(int oid){
		orderInfoService.deleteOrderInfo(oid);//deleteDelivererInfoByDid(did);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/selectAll");
		return mav;
	}
	

	@RequestMapping("/deleteManyOrder")
	public ModelAndView deleteManyOrder(String str){
		int oid=0;
		if(!str.isEmpty()){
			int begin= str.indexOf("=", 0);
			int end= str.indexOf("|", 0);
			while(begin!= -1){
				if(end== -1){
					end= str.length();
				}
				String temp= str.substring(begin+1, end);
				oid= Integer.valueOf(temp).intValue();
				orderInfoService.deleteOrderInfo(oid);//deleteDelivererInfoByDid(did);
				begin= str.indexOf("=", end+1);
				end= str.indexOf("|", end+1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:../orderInfo/selectAll");
		return mav;
	}
}
