package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlHelper {
	public static Connection getConnection() {
		//¼ÓÔØÇý¶¯³ÌÐò
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "127.0.0.1:3306";
		String database = "mydb";
		String role = "root";
		String pwd = "root";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + database,role,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
