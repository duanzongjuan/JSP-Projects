<%@page contentType="text/html" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.juan.entity.*" %>
<%
	List<BookInfo> bookInfoList = (List<BookInfo>)request.getAttribute("bookInfoList");
	List<BookInfo> bookInfoListAll = (List<BookInfo>)request.getAttribute("bookInfoListAll");
	String edit = (String)request.getAttribute("edit");
	String btypeids =(String)request.getAttribute("btypeid");
	int btypeid =0;
	if(btypeids != null && btypeids != "") {
		btypeid= Integer.parseInt(btypeids);
	}
	int pageCount = 0;
	String pageCounts = request.getAttribute("pageCount").toString();
	if(pageCounts != null && pageCounts !="") {
		pageCount = Integer.parseInt(pageCounts);
	}
	int nowPage = 1;
	String nowPages = request.getAttribute("nowPage").toString();
	if(nowPages != null && nowPages !="") {
		nowPage = Integer.parseInt(nowPages);
	}
	int pageSize = 10;
	String pageSizes = request.getAttribute("pageSize").toString();
	if(pageSizes != null && pageSizes !="") {
		pageSize = Integer.parseInt(pageSizes);
	}
 %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书类别管理</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/pintuer.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/background/css/bootstrap.min.css">
		<script src="<%=request.getContextPath() %>/background/js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/background/js/bootstrap.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div style=" margin:0 50px;font-family:'微软雅黑';font-size:14px;width:80%">
		<div style="margin:0 auto; width:100px;font-family:'微软雅黑';font-size:16px;">图书信息管理</div>
		<div class="padding border-bottom" style="float:right;">  
  			<button type="button" class="button border-yellow" data-toggle="modal" data-target="#addBookInfo"><span class="icon-plus-square-o" style="color:#f60;"></span> 添加内容</button>
   		</div>
		<form action="" method="post" name="modifyform">
			<table class="xtable" cellpadding="0" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th width="3%">书编号</th>
						<th width="10%">书名</th>
						<th width="7%">所属类型</th>
						<th width="6%">作者</th>
						<th width="8%">出版社</th>
						<th width="6%">出版日期</th>
						<th width="26%">内容简介</th>
						<th width="7%">图片名称</th>
						<th width="4%">价格</th>
						<th width="4%">会员价</th>
						<th width="4%">书状态</th>
						<th  width="13%" colspan="2">操作</th>
					</tr>
				</thead>
			<%
			if(bookInfoList != null) {
				for(int i=0;i<bookInfoList.size();i++) {
					BookInfo bookInfo = bookInfoList.get(i);
			%>
				<tr> <!-- onmouseover="this.style.background='#f1f8fc'" onmouseout="this.style.background='#fff'" -->
					<td><%=bookInfo.getBid() %></td>
					<td><%=bookInfo.getBookname() %></td>
					<td><%=bookInfo.getBtypeid() %></td>
					<td><%=bookInfo.getAuthor() %></td>
					<td><%=bookInfo.getPbname() %></td>
					<td><%=bookInfo.getPdate() %></td>
					<td><%=bookInfo.getContext() %></td>
					<td><%=bookInfo.getSmallimg() %></td>
					<td><%=bookInfo.getPrice() %></td>
					<td><%=bookInfo.getMemberprice() %></td>
					<td><%if(bookInfo.getBookstates() == 1) {%>已上架<%} else if(bookInfo.getBookstates() == 0){ %>未上架<%}%></td>
					<td style="text-align:center;">
						<div class="button-group">
							<a class="button border-yellow" href=""><span class="icon-edit" style="color:#f60;"></span> 修改</a>
							<!-- <a class="button border-main" href="" >
								<span class="icon-save" style="color:#0ae;"></span> 保存
							</a> -->
							<a class="button border-red" href="">
								<span class="icon-trash-o" style="color: #e33;"></span> 删除
							</a>
						</div>
					</td>
				</tr>
				<%}} %>
			</table>
		</form>
		
		<div style="width:520px;margin:20px auto;">
			<a href="">已上架</a>&nbsp;
			<a href="">未上架</a>&nbsp;
			<a href="">所有</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			共10页
			第10页
			
			<a href="">第一页</a>
			<a href="">上一页</a>
			<a href="">下一页</a>
			<a href="">最后页</a>
			<select name="selectnowPage" onchange="">
					<option value="" selected="selected">第 页</option>
			</select>
		</div>
		
		<div class="modal fade" id="addBookInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel">
							添加图书信息
						</h4>
					</div>
				<form class="form-inline" >
					<div class="modal-body">
						<table width="100%" style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>书名</td>
								<td><input name="bookname" class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>所属类型</td>
								<td><input name="btypeid" class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>作者</td>
								<td><input name="author" class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>出版社</td>
								<td><input class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>出版日期</td>
								<td><input class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>图片名称</td>
								<td><input class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>价格</td>
								<td><input class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>会员价</td>
								<td><input class="form-control" type="text" value=""/></td>
							</tr>
							<tr>
								<td>内容简介</td>
								<td><textarea class="form-control" rows="" cols=""></textarea></td>
							</tr>
						</table>
					     
					</div>
				</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary">
							提交更改
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
	</div>	
		
	
	
</body>
</html>