package com.digital.pojo;

public class ForSearchFood {

	private int rid;
	private String name;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ForSearchFood [rid=" + rid + ", name=" + name + "]";
	}
	
}
