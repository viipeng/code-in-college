package com.digital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.digital.dao.UserDao;
import com.digital.entity.User;
import com.digital.utils.JdbcUtil;

public class UserDaoImpl extends JdbcUtil implements UserDao {

	@Override
	public int addUser(User user) {
		int result = 0;

		String sql = "insert into table_usr(id,userName,password,realName) values(?,?,?,?)";

		Connection conn = JdbcUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getRealName());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, null, null);
		}
		return result;
	}

}
