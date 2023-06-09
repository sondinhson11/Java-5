<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly NSX</h1>
<form:form action="/nsx/add" method="post" modelAttribute="nsx">
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
    <c:forEach items="${listNSX.content}" var="nsx">
        <tr>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <button><a href="/nsx/remove/${nsx.id}">Delete</a></button>
                <button><a href="/nsx/detail/${nsx.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listNSX.totalPages -1}" varStatus="loop">
            <li>
                <a href="/nsx/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>