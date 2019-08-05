package com.digital.dao;

import java.util.List;

import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.OrderInfo;

public interface OrderInfoDAO {

	public int getOid();
		
	public void ordering(OrderInfo oi);
		
	public List<OrderInfo> getOrderInfoByUid(int uid);

	public List<OrderInfo> getEOrderByUid(int uid);

	public List<OrderInfo> getSOrderByUid(int uid);

	public List<OrderInfo> getPOrderByUid(int uid);

	public List<OrderInfo> getROrderByUid1(int uid);

	public List<OrderInfo> getROrderByUid2(int uid);

	public List<OrderInfo> getOrderInfoByRid(int rid);

	public List<OrderInfo> getEOrderByRid(int rid);

	public List<OrderInfo> getSOrderByRid(int rid);

	public List<OrderInfo> getPOrderByRid(int rid);

	public List<OrderInfo> getROrderByRid1(int rid);

	public List<OrderInfo> getROrderByRid2(int rid);

	public void inVisibleOrder(int oid);

	public void isSent(int oid);

	public void havePaid(int oid);

	public void haveRefund(int oid);

	public void evaluate(int oid);
	
	public void addOrder(OrderInfo oi);
	
	public void updateOrder(OrderInfo oi);
	
	public int getFidByOid(int oid);

	public void appealRefund(int oid);

	public void cancelRefund(int oid);

	public void permitRefund(int oid);

	public void refuseRefund(int oid);

	//以下是后台的5个方法
	public List<OrderInfo> getOrderInfoByoid(int oid);

	public List<OrderInfo> getOrderInfoByoidOfRid(ForSearchOfRid fe);
			
	public List<OrderInfo> getOrderInfo();
	
	public void addOrderInfo(OrderInfo oi);
		
	public void deleteOrderInfo(int oid);
		
	public void updateOrderInfo(OrderInfo oi);
}
