package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.bean.User;
import com.example.util.MysqlHelper;


public class UserDao {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//Dao����
	public ArrayList<User> getList() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		//�������ݿ�
		conn = MysqlHelper.getConnection();
		//ִ��sql���
		String sql="select * from user";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		//��rs��ȡ����
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setSex(rs.getString(5));
			user.setGrade(rs.getString(6));
			user.setMyclass(rs.getString(7));
			user.setDepartment(rs.getString(8));
			user.setChinese(rs.getString(9));
			user.setMymath(rs.getString(10));
			user.setField1(rs.getString(11));
			user.setField2(rs.getString(12));
			//������user����list
			list.add(user);
		}
		//�ر����ݿ�
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	//У���û�
	public boolean checkUser(String username,String password) throws SQLException {
		//�������ݿ�
		conn = MysqlHelper.getConnection();
		//ִ��sql���
		String sql="select * from user where username=? and password=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "username");
		pstmt.setString(2, "password");
		rs = pstmt.executeQuery();
		//��rs��ȡ����
		if(rs.next()) {
			rs.close();
			pstmt.close();
			conn.close();
			return true;
		}else {
			rs.close();
			pstmt.close();
			conn.close();
			return false;
		}
	}
	
	//��Ӽ�¼
	public void add(User user) throws SQLException {
		//�������ݿ�
		conn = MysqlHelper.getConnection();
		//ִ��sql���
		String sql="insert into user(username,password,name,sex,grade,myclass,department) "
				+ "values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getSex());
		pstmt.setString(5, user.getGrade());
		pstmt.setString(6, user.getMyclass());
		pstmt.setString(7, user.getDepartment());
		
		pstmt.executeUpdate();
		//�ر����ݿ�
		pstmt.close();
		conn.close();
	}
}
