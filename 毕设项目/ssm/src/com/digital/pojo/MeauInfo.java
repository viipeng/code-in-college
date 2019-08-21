package com.digital.pojo;

public class MeauInfo {

	private int mid;
	private String mname;
	private int rid;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "MeauInfo [mid=" + mid + ", mname=" + mname + ", rid=" + rid
				+ "]";
	}
	
}
