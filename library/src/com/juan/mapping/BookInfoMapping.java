package com.juan.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.juan.db.EntityMapping;
import com.juan.entity.BookInfo;

public class BookInfoMapping implements EntityMapping {

	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		BookInfo bookInfo = new BookInfo(rs.getInt("bid"),rs.getString("bookname"),
				rs.getInt("btypeid"),rs.getString("author"),rs.getString("pbname"),
				rs.getString("context"),rs.getString("smallimg"),rs.getString("bigimg"),
				rs.getDouble("price"),rs.getDouble("memberprice"),rs.getInt("bookstates"),
				rs.getDate("pdate"),rs.getInt("other1"),rs.getInt("other2"),rs.getInt("other3"),
				rs.getString("other4"),rs.getString("other5"),rs.getString("other6"));
		
		/*BookInfo bookinfo = new BookInfo();
		bookinfo.setBid(rs.getInt("bid"));
		bookinfo.setBookname(rs.getString("bookname"));
		bookinfo.setBtypeid(rs.getInt("btypeid"));
		bookinfo.setAuthor(rs.getString("author"));
		bookinfo.setPbname(rs.getString("pbname"));
		bookinfo.setContext(rs.getString("context"));
		bookinfo.setSmallimg(rs.getString("smallimg"));
		bookinfo.setBigimg(rs.getString("bigimg"));
		bookinfo.setPrice(rs.getDouble("price"));
		bookinfo.setMemberprice(rs.getDouble("memberprice"));
		bookinfo.setBookstates(rs.getInt("bookstates"));
		bookinfo.setPdate(rs.getDate("pdate"));
		bookinfo.setOther1(rs.getInt("other1"));
		bookinfo.setOther2(rs.getInt("other2"));
		bookinfo.setOther3(rs.getInt("other3"));
		bookinfo.setOther4(rs.getString("other4"));
		bookinfo.setOther5(rs.getString("other5"));
		bookinfo.setOther6(rs.getString("other6"));*/
		return bookInfo;
	}
}
