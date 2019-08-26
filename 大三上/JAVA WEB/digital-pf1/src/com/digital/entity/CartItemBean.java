package com.digital.entity;

public class CartItemBean {

	private ProductInfo pi;
	private int quantity;
	public CartItemBean() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItemBean(ProductInfo pi, int quantity) {
		super();
		this.pi = pi;
		this.quantity = quantity;
	}

	public ProductInfo getPi() {
		return pi;
	}
	public void setPi(ProductInfo pi) {
		this.pi = pi;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItemBean [pi=" + pi + ", quantity=" + quantity + "]";
	}
	
}
