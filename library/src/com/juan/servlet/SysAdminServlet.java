package com.juan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juan.dao.SysAdminDao;
import com.juan.entity.SysAdmin;

public class SysAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		//��������
		String adminname = request.getParameter("adminname");
		String password = request.getParameter("password");
		String op = request.getParameter("op");
		PrintWriter out = response.getWriter();
		if(op.equals("adminlogin")) {
			SysAdmin sysAdmin = new SysAdmin();
			SysAdminDao sysAdminDao = new SysAdminDao();
			sysAdmin = sysAdminDao.checkUser(adminname, password);
			if(sysAdmin != null && !sysAdmin.equals("")) {
				HttpSession session = request.getSession();
				session.setAttribute("sysAdmin", sysAdmin);
				request.getRequestDispatcher("background/index.jsp").forward(request,response);
			} else {
				out.print("<script>alert('����Ա�û��������������');history.back();</script>");
				/*request.setAttribute("error", "�û������������");
				request.getRequestDispatcher("background/login.jsp").forward(request,response); //����ת��
	*/			/*response.sendRedirect("background/login.jsp");*/ //�����ض���
			}
		} 
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
