package com.andy.model.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andy.system.util.MySQL;

public class UsersModel {
	
	private static Logger log = LoggerFactory.getLogger(UsersModel.class);
	
	public boolean checkUser(String strEmail, String strPassword) {
		
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		try {
				
			preparedStmt = MySQL.getDBConnection().prepareStatement("select * from users where email=? and password=?");
			preparedStmt.setString(1, strEmail);
			preparedStmt.setString(2, strPassword);
			rs = preparedStmt.executeQuery();
			return rs.next();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception exc) {					
					
				}
			}
				
			if (preparedStmt != null) {
				try {
					preparedStmt.close();
				} catch (Exception exc) {					
						
				}
			}
		}
		
		return false;
	}
}
