package com.digital.pojo;

import java.util.List;


//�͹���ʾ�ķ�ҳ
public class Pagination {

	//��������
	private int pageNum;//��ҳ��
	private int pageSize;//һ�������ÿҳҪ��ʾ����������
	private int pageId;//��ǰҳ
	private int pageNowSize;//��ǰҳҪ��ʾ����������
	private int firstThing;//��ǰҳ�ĵ�һ������ĺ�һλ�����ݿ��Ǵ�0��ʼ�����
	private int thingNum;//���������
	
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
