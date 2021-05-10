<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<%--静态包含 head的内容--%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			$(".updateCount").change(function () {
				var name = $(this).parent().parent().find("td:first");
				var id =  $(this).attr("bookID");
				if (confirm("你确定更改当前数量为"+ this.value + "吗？"))
				{
					location.href = "${pageScope.basePath}cartServlet?action=updateCount&id="+id + "&count=" + this.value;
				}
				else {
					this.value = this.defaultValue;
				}
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

			<%@ include file="/pages/common/login_sucess_menu.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.map}">
				<tr>
					<td colspan= "5"><a href="${pageScope.basePath}">你的购物车中没有内容,快去看看商城吧!</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.map}">
				<c:forEach items="${sessionScope.cart.map}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input type="text" style="border: none;width: 20px"  class="updateCount" bookID = "${entry.value.id}" value="${entry.value.count}"/>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalItemPrice}</td>
						<td><a href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.map}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a href="${pageScope.basePath}cartServlet?action=clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>