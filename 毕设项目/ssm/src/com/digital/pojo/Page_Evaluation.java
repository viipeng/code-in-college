package com.digital.pojo;

import java.util.List;

public class Page_Evaluation {

	private Pagination pagination;
	List<Evaluation> NowEvaluation;//当前页要显示的评论
	List<Evaluation> AllEvaluation;//查询到的所有评论
	

	public Page_Evaluation(){
		pagination= new Pagination();
	}
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<Evaluation> getNowEvaluation() {
		return NowEvaluation;
	}
	public void setNowEvaluation(List<Evaluation> nowEvaluation) {
		NowEvaluation = nowEvaluation;
	}
	public List<Evaluation> getAllEvaluation() {
		return AllEvaluation;
	}
	public void setAllEvaluation(List<Evaluation> allEvaluation) {
		AllEvaluation = allEvaluation;
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
