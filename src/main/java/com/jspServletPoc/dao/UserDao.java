package com.jspServletPoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspServletPoc.model.User;
import com.jspServletPoc.util.DBConnectionUtil;

public class UserDao {

	public boolean validateEmail(String emailId) {
		return true;
	}
	
	/**
	 * This method will return ResultSet for UserDetails used in UserDetails.jsp
	 * @param con
	 * @param userName
	 * @return
	 */
	public ResultSet getUserDetails(Connection con, String userName) {
		ResultSet resultSet=null;
		try {
			String sql = "select username, gender, phone, city, state, pin, status from painscriptdb.user where username = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}
	
	/**
	 * This method will be used to get the User object details, used in Header page.
	 */
	public User getUserRequiredDetails(Connection con, String userName) {
		User user =null; 
		ResultSet resultSet=null;
		try {
			user = new User();
			String sql = "select first_name, last_name, role_id from painscriptdb.user where username = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user.setFirst_name(resultSet.getString("first_name"));
				user.setLast_name(resultSet.getString("last_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

}


















