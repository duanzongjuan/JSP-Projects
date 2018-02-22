<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="java.sql.*" %>

<%
request.setCharacterEncoding("gbk");

int id = Integer.parseInt(request.getParameter("id"));
int rootid = Integer.parseInt(request.getParameter("rootid"));
String title = request.getParameter("title");
if(title == null) {
	out.println("error!please use my bbs in the right way!");
	return;
}

title = title.trim();

if(title.equals("")) {
	out.println("title could not be empty!");
	return;
}

String cont = request.getParameter("cont");
if(cont == null) {
	out.println("error!please use my bbs in the right way!");
}

cont = cont.trim();

if(cont.equals("")) {
	out.println("content could not be empty!");
	return;
}

cont = cont.replaceAll("\n", "<br>");

Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/bbs?user=root&password=root";
Connection conn = DriverManager.getConnection(url);

//转账问题(若突然断电或者意外,导致数据不一致)
conn.setAutoCommit(false);

String sql = "insert into article values(null,?,?,?,?,now(),0)"; 
PreparedStatement pstmt = conn.prepareStatement(sql);
Statement stmt = conn.createStatement();


pstmt.setInt(1,id);
pstmt.setInt(2,rootid);
pstmt.setString(3, title);
pstmt.setString(4,cont);
pstmt.executeUpdate();

//回复后当前叶子结点不再是叶子结点,要更新
stmt.executeUpdate("update article set isleaf = 1 where id = " + id);

conn.commit();
conn.setAutoCommit(true);

stmt.close();
pstmt.close();
conn.close();

response.sendRedirect("ShowArticleTree.jsp");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
</body>
</html>