package com.digital.pojo;


public class UserInfo {
	
	private int uid;
	private String username;
	private String password;
	private int usex;
	private float account_balance;
	private int ux_coordinate;
	private int uy_coordinate;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUsex() {
		return usex;
	}
	public void setUsex(int usex) {
		this.usex = usex;
	}
	public float getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	public int getUx_coordinate() {
		return ux_coordinate;
	}
	public void setUx_coordinate(int ux_coordinate) {
		this.ux_coordinate = ux_coordinate;
	}
	public int getUy_coordinate() {
		return uy_coordinate;
	}
	public void setUy_coordinate(int uy_coordinate) {
		this.uy_coordinate = uy_coordinate;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username
				+ ", password=" + password + ", usex=" + usex
				+ ", account_balance=" + account_balance + ", ux_coordinate="
				+ ux_coordinate + ", uy_coordinate=" + uy_coordinate + "]";
	}
	
	
	
	
}
