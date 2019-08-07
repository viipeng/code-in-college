package com.digital.pojo;

import java.util.List;


//餐馆显示的分页
public class Pagination {

	//公共属性
	private int pageNum;//总页数
	private int pageSize;//一般情况下每页要显示的物体数量
	private int pageId;//当前页
	private int pageNowSize;//当前页要显示的物体数量
	private int firstThing;//当前页的第一个物体的后一位，数据库是从0开始计算的
	private int thingNum;//物体的数量
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public int getPageNowSize() {
		return pageNowSize;
	}
	public void setPageNowSize(int pageNowSize) {
		this.pageNowSize = pageNowSize;
	}
	public int getFirstThing() {
		return firstThing;
	}
	public void setFirstThing(int firstThing) {
		this.firstThing = firstThing;
	}
	public int getThingNum() {
		return thingNum;
	}
	public void setThingNum(int thingNum) {
		this.thingNum = thingNum;
	}
	@Override
	public String toString() {
		return "Pagination [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", pageId=" + pageId + ", pageNowSize=" + pageNowSize
				+ ", firstThing=" + firstThing + ", thingNum=" + thingNum + "]";
	}
	
	
	
}
