package com.juan.db;

import java.sql.ResultSet;
import java.sql.SQLException;

//ӳ��
public interface EntityMapping {
	/**
	 * ��rs��ǰ������ת��Ϊһ��ʵ�����
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Object mapping(ResultSet rs) throws SQLException; 
}
