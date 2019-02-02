package com.juan.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.juan.db.JdbcTemplate;
import com.juan.entity.BookType;
import com.juan.mapping.BookTypeMapping;

public class BookTypeDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	//查找所有书类型
	public List<BookType> findAll() {
		List<BookType> list = new Vector<BookType>();
		String sql="select * from booktype ";
		try {
			list = jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//新增图书类型
	public boolean addBookType(BookType bookType){
		int row = 0;
		String sql="insert into booktype (btypeid,parentid,btypename,other4) values(?,?,?,?)";
		Object[] values = new Object[]{
			bookType.getBtypeid(),bookType.getParentid(),
			bookType.getBtypename(),bookType.getOther4()
		};
		try {
			row = jdbcTemplate.update(sql,values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	//删除图书类型(物理删除,表中不存在)
	public boolean deleteBookType(int btypeid) {
		int row1 = 0;
		int row2 = 0;
		/*String sql1 = "select btypeid from booktype where parentid = " + parentid;*/
		String sql1="delete from booktype where btypeid = " + btypeid;
		String sql2="delete from booktype where parentid = " + btypeid;
		try {
			row1 = jdbcTemplate.update(sql1);
			row2 = jdbcTemplate.update(sql2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row1 > 0 && row2 > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//删除图书类型(逻辑删除,表中存在)
	/*public boolean updateIsdelete(int btypeid,String isdelete) {
		int row = 0;
		String sql="update booktype set isdelete = '" + isdelete + "' where btypeid = " + btypeid;
		try {
			row = jdbcTemplate.update(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}*/
	
	//修改图书类型
	public boolean modifyBookType(BookType bookType) {
		int row = 0;
		String sql="update booktype set btypename=?,isdelete=?,other4=? where btypeid=?";
		Object[] values = new Object[]{
				bookType.getBtypename(),
				bookType.getIsdelete(),
				bookType.getOther4(),
				bookType.getBtypeid()
		};
		/*BookType values = new BookType(bookType.getBtypename(),bookType.getIsdelete(),bookType.getOther4(),bookType.getBtypeid());*/
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	//获得总页数
	public int getPageCount(int pageSize) {
		int pageCount = 0;
		String sql="select count(*) from booktype";
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
	public List<BookType> getNowPageData(int pageSize,int nowPage) {
		List<BookType> list = null;
		String sql ="select * from booktype limit " + (nowPage-1)*pageSize + "," + pageSize;
		try {
			list = jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
