package com.digital.service;

import java.util.List;

import com.digital.pojo.Order_food;

public interface Order_foodService {

	public List<Integer> getFidByOid(int oid);

	public void addOrder_food(Order_food order_food);

	public List<Order_food> getOFListByOid(int oid);

	//ºóÌ¨
	public List<Order_food> getOrder_food();
	
	public List<Order_food> getOrder_foodByOFid(int ofid);
		
	public void deleteOrder_food(int ofid);
	
	public void updateOrder_food(Order_food of);

}
