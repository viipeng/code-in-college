package com.digital.pojo;

import java.util.List;

public class Page_Restaurant {

	private Pagination pagination;
	List<RestaurantInfo> NowRestaurant;//当前页要显示的餐馆
	List<RestaurantInfo> AllRestaurant;//查询到的所有餐馆
	

	public Page_Restaurant(){
		pagination= new Pagination();
	}
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<RestaurantInfo> getNowRestaurant() {
		return NowRestaurant;
	}
	public void setNowRestaurant(List<RestaurantInfo> nowRestaurant) {
		NowRestaurant = nowRestaurant;
	}
	public List<RestaurantInfo> getAllRestaurant() {
		return AllRestaurant;
	}
	public void setAllRestaurant(List<RestaurantInfo> allRestaurant) {
		AllRestaurant = allRestaurant;
	}
	//便于获取pagination的变量
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
