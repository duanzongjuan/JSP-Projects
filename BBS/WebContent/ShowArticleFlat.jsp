<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="java.sql.*" %>

<%
int pageSize = 3;
String StrPageNo = request.getParameter("pageNo");
int pageNo;
if(StrPageNo == null || StrPageNo == "") {
	pageNo = 1;
} else {
	try {
		pageNo = Integer.parseInt(StrPageNo.trim());
	} catch(NumberFormatException e) {
		pageNo = 1;
	}
	
	if(pageNo <= 0) pageNo = 1;
}

request.setCharacterEncoding("gbk");

Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/bbs?user=root&password=root";
Connection conn = DriverManager.getConnection(url);

Statement stmtCount = conn.createStatement();
ResultSet rsCount = stmtCount.executeQuery("select count(*) from article where pid = 0");
rsCount.next();
int totalRecords = rsCount.getInt(1);
int totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;  

if(pageNo > totalPages) {
	pageNo = totalPages;
}

int startPage = (pageNo-1) * pageSize;

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from article where pid = 0 order by pdate desc limit " + startPage +"," + pageSize);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
<a href="Post.jsp">发表新帖</a>
<table border="1">
<%
while(rs.next()) {
%>
	<tr>
		<td><%=rs.getString("title") %></td>	
	</tr>
<%
}
rs.close();
stmt.close();
conn.close();
%>
</table>
共<%=totalPages %>页 ,第<%=pageNo %>页
<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo-1%>">上一页</a>&nbsp;&nbsp;
<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo+1%>">下一页</a>
<form name="form1" action="ShowArticleTree.jsp">
	<select name="pageNo" onchange="document.form1.submit()">
		<%
		for(int i=1; i<=totalPages; i++) {	
		%>
		<option value="<%=i%>" <%=(pageNo == i)?"selected":"" %>>第<%=i %>页</option>
		<%
		}
		%>
	</select>
</form>

<form name="form2" action="ShowArticleFlat.jsp">
	<input type="text" size="4" name="pageNo" value="<%=pageNo%>"/>
	<input type="submit" value="go"/>
</form>

</body>
</html>