package com.digital.pojo;

public class Shopping_trolley_food {

	private int sfid;
	private int fid;
	private String fname;
	private String fphoto;
	private float fprice;
	private int amount;
	private int sid;
	
	public int getSfid() {
		return sfid;
	}
	public void setSfid(int sfid) {
		this.sfid = sfid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public float getFprice() {
		return fprice;
	}
	public void setFprice(float fprice) {
		this.fprice = fprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Shopping_trolley_food [sfid=" + sfid + ", fid=" + fid
				+ ", fphoto=" + fphoto + ", fname=" + fname + ", fprice="
				+ fprice + ", amount=" + amount + ", sid=" + sid + "]";
	}
	
}
