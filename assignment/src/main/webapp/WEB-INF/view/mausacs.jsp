<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Mau Sac</h1>
<form:form action="/mau-sac/add" method="post" modelAttribute="mauSac">
    Ma:<form:input path="ma"/><br>
    <form:errors path="ma" cssStyle="color: red"/> <br>
    Ten:<form:input path="ten"/><br>
    <form:errors path="ten" cssStyle="color: red"/> <br>
    <form:button type="dubmit">Add</form:button>
</form:form>
<table border="1px">
    <thead>
    <tr>
        <td>Ma</td>
        <td>Ten</td>
        <td colspan="2">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listMS.content}" var="ms">
        <tr>
            <td>${ms.ma}</td>
            <td>${ms.ten}</td>
            <td>
                <button><a href="/mau-sac/remove/${ms.id}">Delete</a></button>
                <button><a href="/mau-sac/detail/${ms.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listMS.totalPages -1}" varStatus="loop">
            <li>
                <a href="/mau-sac/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>