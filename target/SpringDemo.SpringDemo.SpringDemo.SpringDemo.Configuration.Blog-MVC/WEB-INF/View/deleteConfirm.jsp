<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 23/12/2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<form:form action="/BlogMVC_war_exploded/blog/deleteOk" method="POST" modelAttribute="blog">
    <form:hidden path="id"></form:hidden>

     Title Name: ${blog.title}
    <br><br>
      Content: ${blog.content}
    <br><br>

    <input type="submit" value="Delete"/>
</form:form>

</body>
</html>
