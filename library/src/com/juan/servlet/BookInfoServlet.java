package com.juan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juan.dao.BookInfoDao;
import com.juan.entity.BookInfo;

public class BookInfoServlet extends HttpServlet {

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
		int bookstates = 0;
		String op = request.getParameter("op");
		String bookstate = request.getParameter("bookstates");
		if(bookstate !=null || bookstate != "") {
			bookstates = Integer.parseInt(bookstate);
		}
		String nowPages = null;
		nowPages = request.getParameter("nowPage");
		if(nowPages != null && nowPages != "") {
			nowPage = Integer.parseInt(nowPages);
		}
		BookInfoDao BookInfoDao = new BookInfoDao();
		BookInfo BookInfo = new BookInfo();
		List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
		List<BookInfo> bookInfoListAll = new ArrayList<BookInfo>();
		if("bookinfolist".equals(op)) {
			pageCount = BookInfoDao.getPageCount(pageSize,bookstates);
			bookInfoList = BookInfoDao.getNowPageData(nowPage, pageSize, bookstates);
			bookInfoListAll = BookInfoDao.findAll();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("bookInfoList", bookInfoList);
			request.setAttribute("bookInfolisttAll", bookInfoListAll);
			request.getRequestDispatcher("/background/bookinfo.jsp").forward(request, response);
		} 
		if("addBookInfo".equals(op)){
			String parentids = request.getParameter("parentid");
			int parentid = 0;
			if(parentids != null && parentids != "") {
				parentid = Integer.parseInt(parentids);
			}
			String btypename = request.getParameter("btypename");
			String other4 = request.getParameter("other4");
			BookInfo.setOther4(other4);
			try {
				BookInfoDao.addBookInfo(BookInfo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if("btypedelete".equals(op)) {
			int btypeid = 0;
			String btypeids = request.getParameter("btypeid");
			if(btypeids != null || btypeids != "") {
				btypeid = Integer.parseInt(btypeids);
			}
			BookInfoDao.deleteBookInfo(btypeid);
			bookInfoList = BookInfoDao.getNowPageData(pageSize, nowPage,bookstates);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("bookInfoList", bookInfoList);
			request.getRequestDispatcher("/background/bookinfo.jsp").forward(request, response);
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
			if("1".equals(edit)) {
				bookInfoList = BookInfoDao.getNowPageData(pageSize, nowPage,bookstates);
			} 
			if("2".equals(edit)) {
				BookInfoDao.modifyBookInfo(BookInfo);
				bookInfoList = BookInfoDao.getNowPageData(pageSize, nowPage,bookstates);
			}
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("btypeid", btypeids);
			request.setAttribute("edit", edit);
			request.setAttribute("bookInfoList", bookInfoList);
			request.getRequestDispatcher("/background/bookinfo.jsp").forward(request, response);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
