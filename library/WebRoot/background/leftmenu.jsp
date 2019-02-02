<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>JSP Page</title>
        <script type="text/javascript" src="<%=request.getContextPath() %>/background/js/jquery.js"></script> 
        <script type="text/javascript" src="<%=request.getContextPath() %>/background/js/my.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/style.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/common.css" />
    </head>
    <body>
        <div class="menus_area" id="menus_area" style="">
                <dl style=""><h2 style="background:url(<%=request.getContextPath() %>/background/images/lefttopbg.png) repeat-x; border-radius:2px 2px 0 0; "><p style="margin-left:15px;padding-left:25px; line-height:35px;color:#fff; font-size:14px; font-weight:bold; background:url(<%=request.getContextPath() %>/background/images/icon0.png) no-repeat left center;">功能导航</p></h2></dl>
                <dl class="system_log">
                    <dt>图书管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="<%=request.getContextPath() %>/BookTypeServlet?op=booktypelist" target="mainFrame">图书类别管理</a></dd>
                    <dd><a href="<%=request.getContextPath() %>/BookInfoServlet?op=bookinfolist&bookstates=1" target="mainFrame">图书信息管理</a></dd>
                    <dd><a href="#">寻书管理</a></dd>
                </dl>

                <dl class="custom">
                    <dt>交互管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">评论管理</a></dd>
                    <dd><a href="#">试用/成交客户管理</a></dd>
                    <dd><a href="#">未成交客户管理</a></dd>
                    <dd><a href="#">即将到期客户管理</a></dd>
                </dl>

                <dl class="channel">
                    <dt>订单管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">管理订单</a></dd>
                </dl>

                <dl class="app">
                    <dt>用户管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">系统用户管理</a></dd>
                    <dd><a href="#">用户管理</a></dd>
                </dl>

                <dl class="cloud">
                    <dt>新闻管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">管理新闻</a></dd>
                </dl>

                <dl class="syetem_management">
                    <dt>公告管理<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">管理公告</a></dd>
                </dl>
            </div>
    </body>
</html>
