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
                <dl style=""><h2 style="background:url(<%=request.getContextPath() %>/background/images/lefttopbg.png) repeat-x; border-radius:2px 2px 0 0; "><p style="margin-left:15px;padding-left:25px; line-height:35px;color:#fff; font-size:14px; font-weight:bold; background:url(<%=request.getContextPath() %>/background/images/icon0.png) no-repeat left center;">���ܵ���</p></h2></dl>
                <dl class="system_log">
                    <dt>ͼ�����<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="<%=request.getContextPath() %>/BookTypeServlet?op=booktypelist" target="mainFrame">ͼ��������</a></dd>
                    <dd><a href="<%=request.getContextPath() %>/BookInfoServlet?op=bookinfolist&bookstates=1" target="mainFrame">ͼ����Ϣ����</a></dd>
                    <dd><a href="#">Ѱ�����</a></dd>
                </dl>

                <dl class="custom">
                    <dt>��������<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">���۹���</a></dd>
                    <dd><a href="#">����/�ɽ��ͻ�����</a></dd>
                    <dd><a href="#">δ�ɽ��ͻ�����</a></dd>
                    <dd><a href="#">�������ڿͻ�����</a></dd>
                </dl>

                <dl class="channel">
                    <dt>��������<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">������</a></dd>
                </dl>

                <dl class="app">
                    <dt>�û�����<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">ϵͳ�û�����</a></dd>
                    <dd><a href="#">�û�����</a></dd>
                </dl>

                <dl class="cloud">
                    <dt>���Ź���<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">��������</a></dd>
                </dl>

                <dl class="syetem_management">
                    <dt>�������<img src="<%=request.getContextPath() %>/background/images/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="#">������</a></dd>
                </dl>
            </div>
    </body>
</html>
