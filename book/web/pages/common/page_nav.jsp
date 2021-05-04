<%--
  Created by IntelliJ IDEA.
  User: 11071
  Date: 2021/5/4
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--页码条开始--%>
<div id="page_nav">

<%--    <c:if test="${requestScope.page.pageNo > 1}">--%>
    <a id="firstPage" href="${requestScope.page.url}&pageNo=1">首页</a>
    <a id = "forwardPage" href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
        <%--<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">${requestScope.page.pageNo - 1}</a>--%>
<%--    </c:if>--%>

    <%--页码输出开始--%>
    <c:choose>
        <%--当总页面数小于5的时候--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--当总页数大于5条时--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--最终只显示最后五个--%>
                <c:when test="${requestScope.page.pageNo < 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--只显示前5条时--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--其他情况--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            [${i}]
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>



    <%--页码输出结束--%>
    <%--【${requestScope.page.pageNo}】--%>
<%--    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">--%>
        <%--<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">${requestScope.page.pageNo + 1}</a>--%>
    <a id="nextPage" href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
    <a id="lastPage" href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
<%--    </c:if>--%>
    共${requestScope.page.pageTotal}页，${requestScope.page.totalItems}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input id = "searchButton" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            if(${requestScope.page.pageNo == requestScope.page.pageTotal}) {
                document.getElementById("nextPage").removeAttribute("href");
                document.getElementById("lastPage").removeAttribute("href");
            }
            if(${requestScope.page.pageNo == 1}) {
                document.getElementById("firstPage").removeAttribute("href");
                document.getElementById("forwardPage").removeAttribute("href");
            }
            $("#searchButton").click(function () {
                //javascript提供了一个location地址栏对象
                //它有一个href属性，可以获取浏览器地址栏中的地址 可读可写
                const pageNo = $("#pn_input").val();
                if(pageNo <= ${requestScope.page.pageTotal} && pageNo >= 1)
                    location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
                else {
                    alert("页面不存在！");
                    return false;
                }
            });
        });
    </script>
</div>
<%--页码条结束--%>
