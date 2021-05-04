<%--
  Created by IntelliJ IDEA.
  User: 11071
  Date: 2021/4/30
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%

        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                +"/";
        pageContext.setAttribute("basePath",basePath);
//        System.out.println(basePath);
    %>
<%--    ${ requestScope.basePath }--%>
<%--写base标签，永远固定相对路径--%>


<%--方式一--%>
<%--<base href="<%=basePath%>">--%>



<%--方式二--%>
<base href=${ pageScope.basePath }>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>