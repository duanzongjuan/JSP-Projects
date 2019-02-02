package com.juan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class JdbcTemplate {
	/**
	 * 用来执行 insert update delete语句
	 * @param sql
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	
	//Object... values 可变参数
	public int update(String sql,Object... values) throws SQLException, ClassNotFoundException {
		PreparedStatement psta = null;
		int row = 0;
		try {
			Connection con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			for(int i=0;i<values.length;i++) {
				psta.setObject(i+1,values[i]);
			}
			row = psta.executeUpdate();
		} finally {
			if(psta != null) {
				psta.close();
				psta = null;
			}
		}
		return row;
	}
	
	/**
	 * 用来执行select的查询语句
	 * @param sql
	 * @param mapping
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	
	public List query(String sql,EntityMapping mapping,Object... values) throws SQLException, ClassNotFoundException {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Object> list = new Vector<Object>();
		Connection con = DBManager.getConnection();
		psta = con.prepareStatement(sql);
		for(int i=0;i<values.length;i++) {
			psta.setObject(i+1, values[i]);
		}
		rs = psta.executeQuery();
		while(rs.next()) {
			list.add(mapping.mapping(rs));
		}
		return list;
	}
	
	/**
	 * 得到某个表符合条件的数据的总行数
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public int query(String sql) throws SQLException, ClassNotFoundException {
		PreparedStatement psta = null;
		ResultSet rs = null;
		int result = 0;
		Connection con = DBManager.getConnection();
		psta = con.prepareStatement(sql);
		rs = psta.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
		return result;
	}
}
