package com.example.app;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.bean.User;
import com.example.dao.UserDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("娟娟");
		user.setPassword("789");
		user.setName("段宗娟");
		user.setSex("女");
		user.setGrade("1");
		user.setMyclass("1602");
		user.setDepartment("计算机系");
		try {
			userDao.add(user);
			System.out.println("xxx");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
