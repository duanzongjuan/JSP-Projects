package com.juan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.juan.db.JdbcTemplate;
import com.juan.entity.BookInfo;
import com.juan.mapping.BookInfoMapping;
import com.juan.tools.MyTools;

public class BookInfoDao {
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	//查找所有图书信息
	public List<BookInfo> findAll() {
		List<BookInfo> list = new ArrayList<BookInfo>();
		BookInfo bookInfo = null;
		String sql = "select * from bookinfo";
		try {
			list = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//通过id查找图书信息
	public BookInfo findById(int id) {
		List<BookInfo> list = new Vector<BookInfo>();
		BookInfo bookInfo = null;
		String sql ="select * from bookinfo where bid=" + id;
		try {
			list = jdbcTemplate.query(sql, new BookInfoMapping());
			} catch (ClassNotFoundException e) {
			} catch (SQLException e) {
				e.printStackTrace();
			}
		bookInfo = list.get(0);
		return bookInfo;
	}
	
	//添加图书信息
	public boolean addBookInfo(BookInfo bookInfo) throws ClassNotFoundException {
		int row = 0;
		String pbdate = MyTools.dateToString(bookInfo.getPdate());
		String sql="insert into bookinfo(bid,bookname,btypeid,author,pbname,context,smallimg,bigimg,price,memberprice,bookstates,pdate,other1,other2,other3,other4,other5,other6) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values = new Object[]{
			bookInfo.getBid(),bookInfo.getBookname(),bookInfo.getBtypeid(),bookInfo.getAuthor(),bookInfo.getPbname(),
			bookInfo.getContext(),bookInfo.getSmallimg(),bookInfo.getBigimg(),bookInfo.getPrice(),
			bookInfo.getMemberprice(),bookInfo.getBookstates(),pbdate,bookInfo.getOther1(),
			bookInfo.getOther2(),bookInfo.getOther3(),bookInfo.getOther4(),bookInfo.getOther5(),bookInfo.getOther6()
		};
		try {
			row = jdbcTemplate.update(sql,values );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	//修改图书信息
	public boolean modifyBookInfo(BookInfo bookInfo) {
		int row = 0;
		String sql ="update bookinfo set bookname=?,author=?,btypeid=?,pbname=?,context=?,smallimg=?,bigimg=?,price=?,memberprice=?,bookstates=?,pdate=?,other1=?,other2=?,other3=?,other4=?,other5=?,other6=? where bid= ?";
		String pbdate = MyTools.dateToString(bookInfo.getPdate());
		Object[] values = new Object[]{
				bookInfo.getBookname(),bookInfo.getAuthor(),bookInfo.getBtypeid(),
				bookInfo.getPbname(),bookInfo.getContext(),bookInfo.getSmallimg(),
				bookInfo.getBigimg(),bookInfo.getPrice(),bookInfo.getMemberprice(),
				bookInfo.getBookstates(),pbdate,bookInfo.getOther1(),bookInfo.getOther2(),
				bookInfo.getOther3(),bookInfo.getOther4(),bookInfo.getOther5(),bookInfo.getOther6(),bookInfo.getBid()
		};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	//删除图书信息
	public boolean deleteBookInfo(int bid) {
		int row = 0;
		String sql="delete from bookinfo where bid = " + bid;
		try {
			row = jdbcTemplate.update(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row==1);
	}
	
	//获得总页数
	public int getPageCount(int pageSize,int bookstates) {
		int pageCount = 0;
		String sql="select count(*) from bookinfo where bookstates = " + bookstates;
		try {
			int rowCount = jdbcTemplate.query(sql);
			pageCount = rowCount / pageSize;
			if(rowCount % pageSize != 0) {
				pageCount++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageCount;
	}
	
	//获得当前页的数据
	public List<BookInfo> getNowPageData(int nowPage,int pageSize,int bookstates) {
		List<BookInfo> list = null;
		String sql = "select * from bookinfo where bookstates = " + bookstates + " limit " + (nowPage-1)*pageSize +"," + pageSize;
		try {
			list = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
