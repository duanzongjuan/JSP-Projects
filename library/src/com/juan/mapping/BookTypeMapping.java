package com.juan.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.juan.db.EntityMapping;
import com.juan.entity.BookType;

public class BookTypeMapping implements EntityMapping {
	
	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		BookType bookType = new BookType(rs.getInt("btypeid"),
				rs.getInt("parentid"),rs.getString("btypename"),
				rs.getString("isdelete"),rs.getInt("other1"),
				rs.getInt("other2"),rs.getInt("other3"),
				rs.getString("other4"),rs.getString("other5"),rs.getString("other6"));
		return bookType;
	}
	
}
