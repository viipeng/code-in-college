package com.digital.pojo;

public class BossInfo {

	private int bid;
	private String busername;
	private String bpassword;
	private int bsex;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBusername() {
		return busername;
	}
	public void setBusername(String busername) {
		this.busername = busername;
	}
	public String getBpassword() {
		return bpassword;
	}
	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}
	public int getBsex() {
		return bsex;
	}
	public void setBsex(int bsex) {
		this.bsex = bsex;
	}
	@Override
	public String toString() {
		return "BossInfo [bid=" + bid + ", busername=" + busername
				+ ", bpassword=" + bpassword + ", bsex=" + bsex + "]";
	}
		
}
