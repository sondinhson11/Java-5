<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Cua Hang</h1>
<form:form action="/cua-hang/add" method="post" modelAttribute="cuaHang">
    Ma:<form:input path="ma"/> <br>
    <form:errors path="ma" cssStyle="color: red"/><br>
    Ten:<form:input path="ten"/><br>
    <form:errors path="ten" cssStyle="color: red"/><br>
    DiaChi:<form:input path="diaChi"/><br>
    <form:errors path="diaChi" cssStyle="color: red"/><br>
    ThanhPho:<form:input path="thanhPho"/><br>
    <form:errors path="thanhPho" cssStyle="color: red"/><br>
    QuocGia:<form:select path="quocGia">
    <form:option value="VietNam">VietNam</form:option>
    <form:option value="Lao">Lao</form:option>
</form:select>
    <br>
    <form:button type="dubmit">Add</form:button>
</form:form>
<table border="1px">
    <thead>
    <tr>
        <td>Ma</td>
        <td>Ten</td>
        <td>DiaChi</td>
        <td>ThanhPho</td>
        <td>QuocGia</td>
        <td colspan="2">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCH.content}" var="ch">
        <tr>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <button><a href="/cua-hang/remove/${ch.id}">Delete</a></button>
                <button><a href="/cua-hang/detail/${ch.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listCH.totalPages -1}" varStatus="loop">
            <li>
                <a href="/cua-hang/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>