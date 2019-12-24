<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 24/12/2019
  Time: 06:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form  modelAttribute="blog">
    <form:hidden path="id"></form:hidden>

    Title Name: ${blog.title}
    <br><br>
    Content: ${blog.content}
    <br><br>


</form:form>
</body>
</html>
