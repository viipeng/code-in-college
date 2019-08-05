package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.Order_foodDAO;
import com.digital.pojo.Order_food;
import com.digital.service.Order_foodService;

@Service("order_foodService")
public class Order_foodServiceImpl implements Order_foodService {

	@Autowired
	private Order_foodDAO order_foodDAO;
	
	@Override
	public List<Integer> getFidByOid(int oid) {
		return order_foodDAO.getFidByOid(oid);
	}

	@Override
	public void addOrder_food(Order_food order_food) {
		order_foodDAO.addOrder_food(order_food);
	}

	@Override
	public List<Order_food> getOFListByOid(int oid) {
		return order_foodDAO.getOFListByOid(oid);
	}

	@Override
	public List<Order_food> getOrder_food() {
		return order_foodDAO.getOrder_food();
	}

	@Override
	public List<Order_food> getOrder_foodByOFid(int ofid) {
		return order_foodDAO.getOrder_foodByOFid(ofid);
	}

	@Override
	public void deleteOrder_food(int ofid) {
		order_foodDAO.deleteOrder_food(ofid);
	}

	@Override
	public void updateOrder_food(Order_food of) {
		order_foodDAO.updateOrder_food(of);
	}

}
