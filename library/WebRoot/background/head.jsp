<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="com.juan.entity.*" %>
<%
	Object object = session.getAttribute("sysAdmin");
	SysAdmin sysAdmin = (SysAdmin)object;
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>菜单</title>
         <link href="<%=request.getContextPath() %>/background/css/common.css" rel="stylesheet" type="text/css" />
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/bootstrap.css" />
    </head>
    <body style=" margin: 0px; padding: 0px;">
        <div id="hd">
    		<div class="hd-wrap clearfix">
        		<div class="top-light"></div>
        		<div style="float:right;margin:0 auto; width:350px;">              
        			<div style="font-size:14px; color:#fff;margin:30px 0 0 0px;float:left; padding-left:20px; width:90px; height:18px; line-height:18px; background:url(<%=request.getContextPath() %>/background/images/topuser.png) no-repeat;">  欢迎您,<%=sysAdmin.getAdminname() %></div> 
 					<div style=" margin: 25px 0px;"><a target="_top" href="<%=request.getContextPath() %>"  class="btn btn-success">退出</a></div>
				</div>
			</div>
        </div>
    </body>
</html>
