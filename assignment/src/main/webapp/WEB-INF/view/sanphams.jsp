<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly San Pham</h1>
<form:form action="/san-pham/add" method="post" modelAttribute="sanPham">
    Ma:<form:input path="ma"/><br>
    <form:errors path="ma" cssStyle="color: red"/><br>
    Ten:<form:input path="ten"/><br>
    <form:errors path="ten" cssStyle="color: red"/><br>
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
    <c:forEach items="${listSP.content}" var="sp">
        <tr>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <button><a href="/san-pham/remove/${sp.id}">Delete</a></button>
                <button><a href="/san-pham/detail/${sp.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listSP.totalPages -1}" varStatus="loop">
            <li>
                <a href="/san-pham/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>