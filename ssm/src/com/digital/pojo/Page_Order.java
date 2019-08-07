package com.digital.pojo;

import java.util.List;

public class Page_Order {

	private Pagination pagination;
	private String state;
	List<OrderInfo> NowOrder;//��ǰҳҪ��ʾ�Ĳ�Ʒ
	List<OrderInfo> AllOrder;//��ѯ�������в�Ʒ
	
	public Page_Order(){
		pagination= new Pagination();
	}
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<OrderInfo> getNowOrder() {
		return NowOrder;
	}
	public void setNowOrder(List<OrderInfo> nowOrder) {
		NowOrder = nowOrder;
	}
	public List<OrderInfo> getAllOrder() {
		return AllOrder;
	}
	public void setAllOrder(List<OrderInfo> allOrder) {
		AllOrder = allOrder;
	}

	//���ڻ�ȡpagination�ı���
	public int getPageNum() {
		return pagination.getPageNum();
	}
	public void setPageNum(int pageNum) {
		pagination.setPageNum(pageNum);
	}
	public int getPageSize() {
		return pagination.getPageSize();
	}
	public void setPageSize(int pageSize) {
		pagination.setPageSize(pageSize);
	}
	public int getPageId() {
		return pagination.getPageId();
	}
	public void setPageId(int pageId) {
		pagination.setPageId(pageId);
	}
	public int getPageNowSize() {
		return pagination.getPageNowSize();
	}
	public void setPageNowSize(int pageNowSize) {
		pagination.setPageNowSize(pageNowSize);
	}
	public int getFirstThing() {
		return pagination.getFirstThing();
	}
	public void setFirstThing(int firstThing) {
		pagination.setFirstThing(firstThing);
	}
	public int getThingNum() {
		return pagination.getThingNum();
	}
	public void setThingNum(int thingNum) {
		pagination.setThingNum(thingNum);
	}
	
	
}
