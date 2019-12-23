<%@ page import="SpringDemo.Blog" %><%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 22/12/2019
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List og Blogs</title>
</head>
<body>
<form:form action="saveCustomer" modelAttribute="blog" method="post">
<table>
    <tr>
        <th> ID</th>
        <th>Article Name</th>
        <th>Content </th>
        <th> Action</th>
    </tr>

    <c:forEach var="tempBlogs" items="${userList}">
        <c:url var="updateLink" value="/blog/showBlogForUpdate/${tempBlogs.id}">

        </c:url>
        <c:url var="deleteLink" value="/blog/delete/${tempBlogs.id}">

        </c:url>
        <tr>
            <td> ${tempBlogs.id}</td>
            <td> ${tempBlogs.title}</td>
            <td> ${tempBlogs.content}</td>
            <td><a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are You Sure'))) return false">Delete</a>
            </td>
        </tr>

    </c:forEach>


</table>
</form:form>
</body>
</html>
