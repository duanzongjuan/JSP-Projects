<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.juan.entity.*" %>
<%
	Object object = session.getAttribute("sysAdmin");
	SysAdmin sysAdmin = (SysAdmin)object;
	if(object == null) {
		response.sendRedirect("login.jsp");
	}
 %>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>��������̨����</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/common.css" />
   </head>
   <%--��ʱ <frameset rows="74,*" cols="*" frameborder="NO" border="0" framespacing="0">
		<frame name="topFrame" scrolling="NO" noresize src="<%=request.getContextPath()%>/background/head.jsp" >
		<frameset cols="180,*" frameborder="NO" border="0" framespacing="0" rows="*">
			<frame name="leftFrame" noresize scrolling="auto" src="<%=request.getContextPath()%>/background/leftmenu.jsp">
			<frame name="mainFrame" noresize scrolling="AUTO" src="<%=request.getContextPath()%>/background/main.jsp">
		</frameset>
	</frameset> --%>
<body>
	<div>
		<iframe id="topFrame" src="<%=request.getContextPath()%>/background/head.jsp" ></iframe>
	</div>
	<div>
		<iframe id="leftFrame" src="<%=request.getContextPath()%>/background/leftmenu.jsp" ></iframe>
		<iframe id="mainFrame" name="mainFrame" src="<%=request.getContextPath()%>/background/main.jsp" ></iframe>
	</div>
</body>  
</html>
