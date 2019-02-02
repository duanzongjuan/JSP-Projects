package com.juan.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.juan.dao.BookInfoDao;
import com.juan.entity.BookInfo;
import com.juan.tools.MyTools;

public class TestBookInfoDao {

	public static void main(String[] args) throws ParseException {
		/*BookInfoDao bookInfoDao = new BookInfoDao();
		Date date = null;
		date = DateTool.stringToDate("2018-12-27");
		BookInfo bookInfo = new BookInfo(1,"娟娟",1,"娟娟","娟娟出版社","juanjuan","nullsmall.png","nullbig.png",50,45,1,date,0,0,0,"1","1","1");
		try {
			bookInfoDao.addBookInfo(bookInfo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		testFindAll();
	}
	public static void testFindAll() {
		BookInfoDao bookInfoDao = new BookInfoDao();
		List<BookInfo> list = bookInfoDao.getNowPageData(1, 1, 1);
		System.out.println(list);
	}
	public static void testModifyBookInfo() throws ParseException {
		BookInfoDao bookInfoDao = new BookInfoDao();
		Date date = null;
		date = MyTools.stringToDate("2019-1-22");
		BookInfo bookInfo = new BookInfo(1,"java编程思想",1,"Bruce Eckel","机械工业出版社","编程语言与程序设计","nullsmall.png","nullbig.png",108,89,1,date,0,0,0,"1","1","1");
		System.out.println(bookInfoDao.modifyBookInfo(bookInfo));
	}
}
