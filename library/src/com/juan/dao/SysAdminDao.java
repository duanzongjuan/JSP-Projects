package com.juan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.juan.db.JdbcTemplate;
import com.juan.entity.SysAdmin;
import com.juan.mapping.SysAdminMapping;

public class SysAdminDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	//校验用户
	public  SysAdmin checkUser(String username,String password) {
		List<SysAdmin> list = new Vector<SysAdmin>();
		String sql="select * from sysadmin where adminname =? and password = ?";
		SysAdmin sysadmin = null;
		try {
			list = jdbcTemplate.query(sql, new SysAdminMapping(), username,password);
			/*if(list.get(0) != null) {*/ //数组下标越界
			if(list.size()!= 0) {
				sysadmin = list.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sysadmin;
	}
}
