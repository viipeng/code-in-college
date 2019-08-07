package com.digital.pojo;

public class Evaluation {

	private int eid;
	private String username;
	private int anonymous;
	private int estar;
	private String edate;
	private String content;
	private int is_recommend;
	private String all_food;
	private int oid;
	private int uid;
	private int rid;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(int anonymous) {
		this.anonymous = anonymous;
	}
	public int getEstar() {
		return estar;
	}
	public void setEstar(int estar) {
		this.estar = estar;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIs_recommend() {
		return is_recommend;
	}
	public void setIs_recommend(int is_recommend) {
		this.is_recommend = is_recommend;
	}
	public String getAll_food() {
		return all_food;
	}
	public void setAll_food(String all_food) {
		this.all_food = all_food;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
		return "Evaluation [eid=" + eid + ", username=" + username
				+ ", anonymous=" + anonymous + ", estar=" + estar + ", edate="
				+ edate + ", content=" + content + ", is_recommend="
				+ is_recommend + ", all_food=" + all_food + ", oid=" + oid
				+ ", uid=" + uid + ", rid=" + rid + "]";
	}
	
	
}
