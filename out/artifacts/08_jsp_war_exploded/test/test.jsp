<%--
  Created by IntelliJ IDEA.
  User: Hao He
  Date: 2021/4/29
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <% for (int i = 1; i <= 9; i++) { %>
    <tr>
        <% for (int j = 1; j <= i ; j++) { %>
        <td>
            <%= j + "x" + i  + "=" + (i*j)%>
        </td>
        <% } %>
    </tr>
    <%}%>
    <%
        System.out.println("test");
    %>
</head>
<body>
<%--输出九九乘法口诀表--%>
<table>
    <% for (int i = 1; i <= 9; i++) { %>
        <tr>
            <% for (int j = 1; j <= i ; j++) { %>
            <td>
                <%= j + "x" + i  + "=" + (i*j)%>
            </td>
            <% } %>
        </tr>
    <%}%>
</table>
</body>
</html>
