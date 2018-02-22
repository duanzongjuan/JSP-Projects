<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%
String action = request.getParameter("action");
if(action != null && action.equals("login")) {
String username = request.getParameter("uname"); 
String password = request.getParameter("pwd");
//String remember = request.getParameter("remember");

if(username == null || !username.equals("admin")) {
	out.println("username error!");
} else if(password == null || !password.equals("admin")) {
	out.println("password error!");
} else {
	session.setAttribute("admin","true");
	response.sendRedirect("ShowArticleTree.jsp");
	}
}
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

</head>

<body>

<div class="signin">
	<div class="signin-head"><img src="images/login_pic.png" alt="" class="img-circle"></div>
	<form action="Login.jsp" method="post" class="form-signin" role="form">
		<input type="hidden" name="action" value="login"/>
		<input type="text" name="uname" class="form-control" placeholder="用户名" required autofocus />
		<input type="password" name="pwd" class="form-control" placeholder="密码" required />
		<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		<label class="checkbox">
			<input type="checkbox" name="remember" value="remember-me"/> 记住我
		</label>
	</form>
</div>

</body>
</html>
