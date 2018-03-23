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
	
	//Dao方法
	public ArrayList<User> getList() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		//连接数据库
		conn = MysqlHelper.getConnection();
		//执行sql语句
		String sql="select * from user";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		//从rs读取数据
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
			//将对象user加入list
			list.add(user);
		}
		//关闭数据库
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	//校验用户
	public boolean checkUser(String username,String password) throws SQLException {
		//连接数据库
		conn = MysqlHelper.getConnection();
		//执行sql语句
		String sql="select * from user where username=? and password=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "username");
		pstmt.setString(2, "password");
		rs = pstmt.executeQuery();
		//从rs读取数据
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
	
	//添加纪录
	public void add(User user) throws SQLException {
		//连接数据库
		conn = MysqlHelper.getConnection();
		//执行sql语句
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
		//关闭数据库
		pstmt.close();
		conn.close();
	}
}
