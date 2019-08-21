package com.digital.pojo;


public class OrderInfo {

	private int oid;
	private String rname;
	private String rphoto;
	private String all_food;
	private float consumption;
	private String ostate;
	private String odate;
	private int visible;
	private int uid;
	private int rid;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public String getAll_food() {
		return all_food;
	}
	public void setAll_food(String all_food) {
		this.all_food = all_food;
	}
	public float getConsumption() {
		return consumption;
	}
	public void setConsumption(float consumption) {
		this.consumption = consumption;
	}
	public String getOstate() {
		return ostate;
	}
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "OrderInfo [oid=" + oid + ", rname=" + rname + ", rphoto="
				+ rphoto + ", all_food=" + all_food + ", consumption="
				+ consumption + ", ostate=" + ostate + ", odate=" + odate
				+ ", visible=" + visible + ", uid=" + uid + ", rid=" + rid
				+ "]";
	}
	
	
		
				
}
