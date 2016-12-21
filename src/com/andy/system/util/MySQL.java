package com.andy.system.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQL {
	
	private static Logger log = LoggerFactory.getLogger(MySQL.class);
	
	private static Connection conn = null;
	public static Connection setDBConnection(String strConInfo) {
		
		if (MySQL.conn == null) {
			try {
				log.error("new DB Connection...");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				MySQL.conn = DriverManager.getConnection(strConInfo);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		return MySQL.conn;
	}
	
	public static Connection getDBConnection() {
		
		if (MySQL.conn == null) log.error("MySQL connection is not initiated!");
		return MySQL.conn;
	}
}
