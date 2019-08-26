package com.digital.entity;

public class UserInfo {
	
	private int id;
	private String userName;
	private String password;
	private String realName;
	
	public UserInfo(){
		
	}
	
	public UserInfo(String userName, String password, 
			String realName) {
		super();
//		this.id = id;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getpassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ""
				+ ", password=" + password
				+ ", realName=" + realName + "]";
	}
}
