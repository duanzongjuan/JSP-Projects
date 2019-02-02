<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台登录</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/style2.0.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/login.css">
<style type="text/css">
	
</style>
<body>
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">知</div></li>
    	<li><div style="margin-left:40px;">识</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">图书后台管理平台</div>
		<div class="title1">计算机、小说、文学、历史、散文</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="<%=request.getContextPath()%>/background/images/page1_0.png">
				<img alt="" class="img1 png" src="<%=request.getContextPath()%>/background/images/page1_1.png">
				<img alt="" class="img2 png" src="<%=request.getContextPath()%>/background/images/page1_2.png">
			</ul>
		</div>
		<img alt="" class="img3 png" src="<%=request.getContextPath()%>/background/images/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
	<div class="tyg-div-form">
		<form action="SysAdminServlet" method="post" name="adminlogin">
			<input name="op" type="hidden" value="adminlogin"/>
				<h2>登录</h2><p class="tyg-p">欢迎访问  图书管理系统</p>
				<div style="margin:5px 0px;">
					<input name="adminname" type="text" placeholder="请输入账号..."/>
				</div>
				<div style="margin:5px 0px;">
					<input name="password" type="password" placeholder="请输入密码..."/>
				</div>
				<div style="margin:5px 0px;">
					<input name="yanzhengma" type="text" style="width:150px;" placeholder="请输入验证码..."/>
					<img src="<%=request.getContextPath()%>/background/images/1.png" style="vertical-align:bottom;" alt="验证码"/>
				</div>
				<button type="submit">登<span style="width:20px;"></span>录</button>
		</form>
	</div>
</div>


<script type="text/javascript" src="<%=request.getContextPath()%>/background/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/background/js/com.js"></script>
<!--[if IE 6]>
<script language="javascript" type="text/javascript" src="background/script/ie6_png.js"></script>
<script language="javascript" type="text/javascript">
DD_belatedPNG.fix(".png");
</script>
<![endif]-->
</body>
</html>