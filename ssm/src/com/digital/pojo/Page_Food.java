package com.digital.pojo;

import java.util.List;

public class Page_Food {

	private Pagination pagination;
	private int mid;//当前菜品所属的菜单的ID
	List<FoodInfo> NowFood;//当前页要显示的菜品
	List<FoodInfo> AllFood;//查询到的所有菜品
	

	public Page_Food(){
		pagination= new Pagination();
	}
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public List<FoodInfo> getNowFood() {
		return NowFood;
	}
	public void setNowFood(List<FoodInfo> nowFood) {
		NowFood = nowFood;
	}
	public List<FoodInfo> getAllFood() {
		return AllFood;
	}
	public void setAllFood(List<FoodInfo> allFood) {
		AllFood = allFood;
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
