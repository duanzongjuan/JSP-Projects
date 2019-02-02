package com.juan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//b/s应用连接肯定不是单态的,以后使用数据库连接池DBCP
//懒汉单态模式
public class DBManager {
	private static Connection conn=null;
	
	//构造方法私有,外部不能创建对象
	private DBManager() {
		
	}
	
	//静态方法只能调用静态对象
	public synchronized static Connection getConnection()  throws ClassNotFoundException, SQLException{
		if(conn == null) {
			Class.forName(Config.DRIVER);
			conn = DriverManager.getConnection(Config.URL,Config.UNAME,Config.PWD);
		}
		return conn;
	}
}

