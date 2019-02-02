<%@page contentType="text/html" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.juan.entity.*" %>
<%
	List<BookType> bookTypeList = (List<BookType>)request.getAttribute("bookTypeList");
	List<BookType> bookTypeListAll = (List<BookType>)request.getAttribute("bookTypeListAll");
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
	function isshow() {
		var fr = document.getElementById('selectform');
		fr.submit();
	}
	function del() {
		if(confirm("确定要删除吗?"));
	}
	function modifytype(url) {
		document.modifyform.action = url;
		document.modifyform.submit();
		alert("保存图书类型成功!");
	}
	function getNowPage(nowPage) {
		window.location="BookTypeServlet?op=booktypelist&nowPage=" + nowPage;
	}
</script>
</head>
<body>
	<div style=" margin:0 50px;font-family:'微软雅黑';font-size:14px;width:80%">
		<div style="margin:0 auto; width:100px;font-family:'微软雅黑';font-size:16px;">图书类别管理</div>
		<div class="padding border-bottom" style="float:right;">  
  			<button type="button" class="button border-yellow" data-toggle="modal" data-target="#addContent"><span class="icon-plus-square-o" style="color:#f60;"></span> 添加内容</button>
   		</div>
		<form action="" method="post" name="modifyform">
			<table class="xtable" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th>类别编号</th>
						<th>父菜单ID</th>
						<th>类别名称</th>
						<th>是否显示</th>
						<th>描述</th>
						<th colspan="2">操作</th>
					</tr>
				</thead>
				<%
					if(bookTypeList != null) {
						for(int i=0; i< bookTypeList.size();i++){
							BookType bookType = bookTypeList.get(i);
				%>
				<tr <% if(i % 2 == 0) {%> style="background-color: #f1f8fc;"<%} %>> <!-- onmouseover="this.style.background='#f1f8fc'" onmouseout="this.style.background='#fff'" -->
					<td><%if(bookType != null){%><%=bookType.getBtypeid() %><%} %></td>
					<td><%if(bookType != null){%><%=bookType.getParentid() %><%} %></td>
					<td><%if("1".equals(edit) && bookType.getBtypeid() == btypeid) {%><input size="8" name="btypename" type="text" class="form-control" value="<%if(bookType != null && bookType.getBtypename() != null){%><%=bookType.getBtypename() %><%} %>"/><%}else{%><%if(bookType != null && bookType.getBtypename() != null){%><%=bookType.getBtypename() %><%}}%></td>
					<td>
						<select name="isdelete" class="form-control" <%if(!"1".equals(edit)){ %>disabled="disabled" style="background-color: #fff;"<%} %>>
							<option value="1" <%if(bookType != null && "1".equals(bookType.getIsdelete())){ %>selected="selected"<%} %>>是</option>
							<option value="2" <%if(bookType != null && "2".equals(bookType.getIsdelete())){ %>selected="selected"<%} %>>否</option>
						</select>
					</td>
					<td><%if("1".equals(edit) && bookType.getBtypeid() == btypeid) {%><input size="8" name="other4" type="text" class="form-control" value="<%if(bookType != null && bookType.getOther4() != null){%><%=bookType.getOther4() %><%} %>"/><%}else{%><%if(bookType != null && bookType.getOther4() != null){%><%=bookType.getOther4() %><%}}%></td>
					<td style="text-align:center;">
						<div class="button-group">
							<a class="button border-yellow" href="BookTypeServlet?op=btypemodify&edit=1&nowPage=<%=nowPage %>&btypeid=<%=bookType.getBtypeid() %>"><span class="icon-edit" style="color:#f60;"></span> 修改</a>
							<a class="button border-main" <%if("1".equals(edit)){ %> href="javascript:modifytype('BookTypeServlet?op=btypemodify&nowPage=<%=nowPage %>&edit=2&btypeid=<%=bookType.getBtypeid() %>')" <%} %>>
								<span class="icon-save" style="color:#0ae;"></span> 保存
							</a>
							<a class="button border-red" href="BookTypeServlet?op=btypedelete&btypeid=<%=bookType.getBtypeid() %>" onclick="return del()">
								<span class="icon-trash-o" style="color: #e33;"></span> 删除
							</a>
						</div>
					</td>
				</tr>
				<%}}%>
			</table>
		</form>
		<div style="width:350px;margin:20px auto;">
			共<%=pageCount %>页
			第 <%=nowPage %>页
			<%if(nowPage != 1) {%>
			<a href="javascript:void(0);" onclick="getNowPage(1)">第一页</a>
			<a href="javascript:void(0);" onclick="getNowPage(<%=nowPage%>-1)">上一页</a>
			<%} else { %>
			第一页
			上一页
			<%} if(nowPage != pageCount) { %>
			<a href="javascript:void(0);" onclick="getNowPage(<%=nowPage%>+1)">下一页</a>
			<a href="javascript:void(0);" onclick="getNowPage(<%=pageCount%>)">最后页</a>
			<%} else { %>
			下一页
			最后页
			<%} %>
			<select name="selectnowPage" onchange="getNowPage(this.value)">
				<%for(int i=0;i<pageCount;i++) { %>
					<option value="<%=i+1%>" <%if(i+1 == nowPage) {%>selected="selected"<%} %>>第<%=i+1%>页</option>
				<%} %>
			</select>
		</div>
	</div>
	
		<!-- 模态框（Modal） -->
	<div class="modal fade" id="addContent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">新增图书类型</h4>
				</div>
					<div class="modal-body">
						<div>所属类型
							<select id="parentid" name="parentid" class="form-control">
								<option value="0">--请选择--</option>
								<%
									if(bookTypeListAll != null) {
										for(int i=0; i< bookTypeListAll.size();i++){
											BookType bookTypeAll = bookTypeListAll.get(i);
											if(bookTypeAll.getParentid() == 0) {
								%>
									<option value="<%if(bookTypeAll != null){%><%=bookTypeAll.getBtypeid()%><%} %>" <%if("i+1".equals(bookTypeAll.getParentid())){ %>selected="selected"<%}%>>
										<%if(bookTypeAll != null){%><%=bookTypeAll.getBtypename()%><%} %>
									</option>
								<%}}}%>
							</select>
						</div>
						<div>类型名称<input id="btypename" name="btypename" type="text" class="form-control"/></div>
						<div>描述<textarea id="other4" name="other4" class="form-control"></textarea></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" onclick="addBookType()">
							提交更改
						</button>
					</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<script>
		function addBookType() {
			var parentid=$("#parentid").val();
			var btypename=$("#btypename").val();
			var other4=$("#other4").val();
			if(btypename == "" || other4 == "") {
				alert("请输入图书类型名称或者描述");
				return false;
			} else {
			$.ajax({
				type:"POST",
				url:"BookTypeServlet",
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				/* data:"btypeid="+btypeid+"&parentid="+parentid+"&btypename="+btypename+"&other4="+other4+"&op="+addbooktype, */
				data:{
					"op":"addbooktype",
					"parentid":parentid,
					"btypename":btypename,
					"other4":other4,
				},
				success:function(data) {
					$("#addContent").modal('hide');
						alert("新增图书类型成功!");
					window.location.reload();
					/* window.location.href="background/booktype.jsp"; */
				},
				error:function(){
					alert("异常!");
				},
			});
		}
	}
	</script>
	
</body>
</html>