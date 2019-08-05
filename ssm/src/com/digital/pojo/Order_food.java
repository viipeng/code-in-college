package com.digital.pojo;

public class Order_food {
	
	private int ofid;
	private int fid;
	private String fname;
	private String fphoto;
	private float fprice;
	private int amount;
	private int oid;
	
	public int getOfid() {
		return ofid;
	}
	public void setOfid(int ofid) {
		this.ofid = ofid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
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
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Order_food [ofid=" + ofid + ", fid=" + fid + ", fname=" + fname
				+ ", fphoto=" + fphoto + ", fprice=" + fprice + ", amount="
				+ amount + ", oid=" + oid + "]";
	}
	
	
}
