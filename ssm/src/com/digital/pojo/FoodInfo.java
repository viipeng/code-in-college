package com.digital.pojo;

public class FoodInfo {

	private int fid;
	private String fname;
	private String fphoto;
	private float fprice;
	private String fdescription;
	private int fsales_volume;
	private int great;
	private int mid;
	
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
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	public int getGreat() {
		return great;
	}
	public void setGreat(int great) {
		this.great = great;
	}
	public int getFsales_volume() {
		return fsales_volume;
	}
	public void setFsales_volume(int fsales_volume) {
		this.fsales_volume = fsales_volume;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "FoodInfo [fid=" + fid + ", fname=" + fname + ", fphoto="
				+ fphoto + ", fprice=" + fprice + ", fdescription="
				+ fdescription + ", great=" + great + ", fsales_volume="
				+ fsales_volume + ", mid=" + mid + "]";
	}
					
}
