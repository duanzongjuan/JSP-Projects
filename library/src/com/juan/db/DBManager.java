package com.juan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//b/sӦ�����ӿ϶����ǵ�̬��,�Ժ�ʹ�����ݿ����ӳ�DBCP
//������̬ģʽ
public class DBManager {
	private static Connection conn=null;
	
	//���췽��˽��,�ⲿ���ܴ�������
	private DBManager() {
		
	}
	
	//��̬����ֻ�ܵ��þ�̬����
	public synchronized static Connection getConnection()  throws ClassNotFoundException, SQLException{
		if(conn == null) {
			Class.forName(Config.DRIVER);
			conn = DriverManager.getConnection(Config.URL,Config.UNAME,Config.PWD);
		}
		return conn;
	}
}

