package com.digital.pojo;

public class RestaurantInfo {

	private int rid;
	private String rname;
	private String rphoto;
	private float rstar;
	private float sending_fee;
	private float shipping_fee;
	private float cpc;
	private int arrival;
	private int rsales_volume;
	private String rcategory;
	private int rprepare_time;
	private int rvelocity;
	private int rx_coordinate;
	private int ry_coordinate;
	private String rdescription;
	private int minute;
	private float distance;
	private int rrecommendation;
	private int bid;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphoto() {
		return rphoto;
	}
	public void setRphoto(String rphoto) {
		this.rphoto = rphoto;
	}
	public float getRstar() {
		return rstar;
	}
	public void setRstar(float rstar) {
		this.rstar = rstar;
	}
	public float getSending_fee() {
		return sending_fee;
	}
	public void setSending_fee(float sending_fee) {
		this.sending_fee = sending_fee;
	}
	public float getShipping_fee() {
		return shipping_fee;
	}
	public void setShipping_fee(float shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
	public float getCpc() {
		return cpc;
	}
	public void setCpc(float cpc) {
		this.cpc = cpc;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public int getRsales_volume() {
		return rsales_volume;
	}
	public void setRsales_volume(int rsales_volume) {
		this.rsales_volume = rsales_volume;
	}
	public String getRcategory() {
		return rcategory;
	}
	public void setRcategory(String rcategory) {
		this.rcategory = rcategory;
	}
	public int getRprepare_time() {
		return rprepare_time;
	}
	public void setRprepare_time(int rprepare_time) {
		this.rprepare_time = rprepare_time;
	}
	public int getRvelocity() {
		return rvelocity;
	}
	public void setRvelocity(int rvelocity) {
		this.rvelocity = rvelocity;
	}
	public int getRx_coordinate() {
		return rx_coordinate;
	}
	public void setRx_coordinate(int rx_coordinate) {
		this.rx_coordinate = rx_coordinate;
	}
	public int getRy_coordinate() {
		return ry_coordinate;
	}
	public void setRy_coordinate(int ry_coordinate) {
		this.ry_coordinate = ry_coordinate;
	}
	public String getRdescription() {
		return rdescription;
	}
	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getRrecommendation() {
		return rrecommendation;
	}
	public void setRrecommendation(int rrecommendation) {
		this.rrecommendation = rrecommendation;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "RestaurantInfo [rid=" + rid + ", rname=" + rname + ", rphoto="
				+ rphoto + ", rstar=" + rstar + ", sending_fee=" + sending_fee
				+ ", shipping_fee=" + shipping_fee + ", cpc=" + cpc
				+ ", arrival=" + arrival + ", rsales_volume=" + rsales_volume
				+ ", rcategory=" + rcategory + ", rprepare_time="
				+ rprepare_time + ", rvelocity=" + rvelocity
				+ ", rx_coordinate=" + rx_coordinate + ", ry_coordinate="
				+ ry_coordinate + ", rdescription=" + rdescription
				+ ", minute=" + minute + ", distance=" + distance
				+ ", rrecommendation=" + rrecommendation + ", bid=" + bid + "]";
	}
	
				
	
}
