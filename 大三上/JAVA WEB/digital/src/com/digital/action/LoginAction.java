package com.digital.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		conn = DriverManager.getConnection(url, "csdb", "w6xD7bh75JvbeBur");

		String sql = "select * from table_usr where userName='" + this.getUserName() + "' and password='"
				+ this.getPassword() + "'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		String result = "";
		if (rs.next()) {
			result = "ok";
		} else {
			result = "error";
		}
		return result;
	}

}
