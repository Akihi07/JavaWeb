<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图书管理</title>
	<%--静态包含 head的内容--%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function (){
			$("a.deleteClass").click(function (){
				/*在当前事件响应函数中包含了一个this对象，该this对象表示当成正在响应事件的DOM对象
				* confirm确认函数，用户点击确定返回True 用户点击取消返回False*/
				return confirm("你确定删除["+$(this).parent().parent().find("td:first").text()+"]这本图书吗？");
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%--静态包含菜单管理内容--%>
		<%@ include file="/pages/common/manager_menu.jsp" %>


	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.books}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.store}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>
			</tr>
		</table>
	</div>

	<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>