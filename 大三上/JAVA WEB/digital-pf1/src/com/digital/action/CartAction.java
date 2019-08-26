package com.digital.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.digital.entity.CartItemBean;
import com.digital.entity.ProductInfo;
import com.digital.service.ProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	private int productInfoId;
	private int quantity;  //修改
	private Map<String, Object> session;
	private ProductInfoService productInfoService;
	public String addCart(){
		Map cart =(Map) session.get("CART");
		if(cart==null){
			cart=new HashMap();
			session.put("CART", cart);
		}
		ProductInfo productInfo = productInfoService.getProductInfoByPid(productInfoId);
		CartItemBean ci=(CartItemBean) cart.get(productInfoId);
		if(ci==null)
		{
			CartItemBean cib= new CartItemBean(productInfo, 1);
			cart.put(productInfo.getId(),cib);
		}else{
				ci.setQuantity(ci.getQuantity()+1);
		}
		return "cart";
	}
	public String updateCart(){
		Map cart =(Map) session.get("CART");
		CartItemBean ci=(CartItemBean) cart.get(productInfoId);
		ci.setQuantity(quantity);
		
		return "cart";
	}
	public String delCart(){
		Map cart =(Map) session.get("CART");
		cart.remove(productInfoId);
		return "cart";
	}
	public String clearCart(){
		Map cart =(Map) session.get("CART");
		cart.clear();
		return "cart";
	}
	
	
	public int getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(int productInfoId) {
		this.productInfoId = productInfoId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductInfoService getProductInfoService() {
		return productInfoService;
	}
	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}
	 
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
