package com.juan.db;

import java.sql.ResultSet;
import java.sql.SQLException;

//映射
public interface EntityMapping {
	/**
	 * 把rs当前行数据转换为一个实体对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Object mapping(ResultSet rs) throws SQLException; 
}
