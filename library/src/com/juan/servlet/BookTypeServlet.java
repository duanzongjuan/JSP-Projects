package com.juan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juan.dao.BookTypeDao;
import com.juan.entity.BookType;
import com.juan.tools.MyTools;

public class BookTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收数据
		int pageCount = 0;
		int pageSize = 10;
		int nowPage = 1;
		String op = request.getParameter("op");
		String nowPages = null;
		nowPages = request.getParameter("nowPage");
		if(nowPages != null && nowPages != "") {
			nowPage = Integer.parseInt(nowPages);
		}
		BookTypeDao bookTypeDao = new BookTypeDao();
		BookType bookType = new BookType();
		List<BookType> bookTypeList = new ArrayList<BookType>();
		List<BookType> bookTypeListAll = new ArrayList<BookType>();
		if("booktypelist".equals(op)) {
			pageCount = bookTypeDao.getPageCount(pageSize);
			bookTypeList = bookTypeDao.getNowPageData(pageSize, nowPage);
			bookTypeListAll = bookTypeDao.findAll();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("bookTypeList", bookTypeList);
			request.setAttribute("bookTypeListAll", bookTypeListAll);
			request.getRequestDispatcher("/background/booktype.jsp").forward(request, response);
		} 
		if("addbooktype".equals(op)){
			String parentids = request.getParameter("parentid");
			int parentid = 0;
			if(parentids != null && parentids != "") {
				parentid = Integer.parseInt(parentids);
			}
			String btypename = request.getParameter("btypename");
			String other4 = request.getParameter("other4");
			bookType.setParentid(parentid);
			bookType.setBtypename(btypename);
			bookType.setOther4(other4);
			bookTypeDao.addBookType(bookType);
			/*pageCount = bookTypeDao.getPageCount(pageSize);*/
		}
		
		if("btypedelete".equals(op)) {
			int btypeid = 0;
			String btypeids = request.getParameter("btypeid");
			if(btypeids != null || btypeids != "") {
				btypeid = Integer.parseInt(btypeids);
			}
			bookTypeDao.deleteBookType(btypeid);
			pageCount = bookTypeDao.getPageCount(pageSize);
			bookTypeList = bookTypeDao.getNowPageData(pageSize, nowPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("bookTypeList", bookTypeList);
			request.getRequestDispatcher("/background/booktype.jsp").forward(request, response);
		}
		if("btypemodify".equals(op)) {
			String btypeids = request.getParameter("btypeid");
			String btypename = request.getParameter("btypename");
			String isdelete = request.getParameter("isdelete");
			String other4 = request.getParameter("other4");
			int btypeid = 0;
			if(btypeids != null && btypeids != "") {
				btypeid = Integer.parseInt(btypeids);
			}
			String edit = request.getParameter("edit");
			pageCount = bookTypeDao.getPageCount(pageSize);
			if("1".equals(edit)) {
				bookTypeList = bookTypeDao.getNowPageData(pageSize, nowPage);
			} 
			if("2".equals(edit)) {
				bookType.setBtypename(btypename);
				bookType.setIsdelete(isdelete);
				bookType.setOther4(other4);
				bookType.setBtypeid(btypeid);
				bookTypeDao.modifyBookType(bookType);
				bookTypeList = bookTypeDao.getNowPageData(pageSize, nowPage);
			}
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("btypeid", btypeids);
			request.setAttribute("edit", edit);
			request.setAttribute("bookTypeList", bookTypeList);
			request.getRequestDispatcher("/background/booktype.jsp").forward(request, response);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
