<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="java.sql.*" %>

<%!
private void del(Connection conn,int id, int pid) {
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		stmt = conn.createStatement();
		String sql ="select * from article where pid = " + id; 
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			del(conn,rs.getInt("id"),rs.getInt("pid"));
		}
		//删完孩子们,再把自己删了
		stmt.executeUpdate("delete from article where id = " + id);
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		try{
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
%>
<%
String admin = (String)session.getAttribute("admin");
if(admin == null || !admin.equals("true")) {
	out.println("哈哈！");
	return;
}
%>

<%
int id = Integer.parseInt(request.getParameter("id"));
int pid = Integer.parseInt(request.getParameter("pid"));

Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/bbs?user=root&password=root";
Connection conn = DriverManager.getConnection(url);

//转账问题(若突然断电或者意外,导致数据不一致)
conn.setAutoCommit(false);

//如果要删除的帖子有孩子，则先删掉孩子们.
del(conn,id,pid);

//判断是否有其他孩子帖子,如果没有,则成为叶子结点
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select count(*) from article where pid = " + pid);
rs.next();
int count = rs.getInt(1);
rs.close();
stmt.close();

if(count <= 0) {
	Statement stmtUpdate = conn.createStatement();
	stmtUpdate.executeUpdate("update article set isleaf = 0 where id = " + pid);
	stmtUpdate.close();
}

conn.commit();
conn.setAutoCommit(true);

conn.close();

response.sendRedirect("ShowArticleTree.jsp");

%>