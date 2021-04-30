<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.atguigu.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hao He
  Date: 2021/4/29
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px black solid;
            border-collapse: collapse;
            width: 600px;
        }
        td,tr{
            border: black solid;
        }
    </style>
</head>
<body>
    <%
        //LinkedList<Student> students = new LinkedList<>();

        List<Student> students = (List<Student>) request.getAttribute("StringList");
        //for (int i = 0; i < 10; i++){
        //    Integer id = i;
        //    String name = "name" + i ;
        //    Integer age  = 10+i % 2;
        //    String phone = "phone" + i;
        //    students.add(new Student(id,name,age,phone));
        //}
    %>

<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>号码</td>
        <td>修改</td>
    </tr>
    <%for (Student student : students) {%>
       <tr>
           <td><%= student.getId()%></td>
           <td><%= student.getName()%></td>
           <td><%= student.getAge()%></td>
           <td><%= student.getPhone()%></td>
           <td>修改</td>
       </tr>
    <%}%>
</table>

</body>
</html>
