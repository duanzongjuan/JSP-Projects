package com.juan.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.juan.dao.BookTypeDao;
import com.juan.entity.BookType;

public class TestBookTypeDao {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*testaddbooktype();*/
		/*testdeletebooktype();*/
		testGetNowPageData();
	}
	
	public static void testbooktypelist() {
		BookTypeDao bookTypeDao = new BookTypeDao();
		List<BookType> list = new ArrayList<BookType>();
		list = bookTypeDao.findAll();
		System.out.println(list);
	}
	
	public static void testaddbooktype() throws ClassNotFoundException, SQLException {
		BookTypeDao bookTypeDao = new BookTypeDao();
		BookType bookType = new BookType();
		bookType.setBtypeid(13);
		bookType.setParentid(0);
		bookType.setBtypename("c#�������");
		bookType.setOther4("c#�������c#�������c#�������");
		System.out.println(bookTypeDao.addBookType(bookType));
	}
	
	public static void testmodifybooktype() {
		BookTypeDao bookTypeDao = new BookTypeDao();
		BookType bookType = new BookType();
		bookType.setBtypename("����Ե��");
		bookType.setOther4("����Ե�����Ե�����Ե��");
		bookType.setBtypeid(21);
		System.out.println(bookTypeDao.modifyBookType(bookType));
	}
	
	public static void testGetNowPageData() {
		int pageSize = 10;
		int nowPage = 1;
		BookTypeDao bookTypeDao = new BookTypeDao();
		List<BookType> list = new ArrayList<BookType>();
		list = bookTypeDao.getNowPageData(pageSize, nowPage);
		System.out.println(list);
	}
}
