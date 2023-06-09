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
<form:form action="/cua-hang/update/${cuaHang.id}" method="post" modelAttribute="cuaHang">
    Ma:<form:input path="ma"/>
    Ten:<form:input path="ten"/>
    DiaChi:<form:input path="diaChi"/>
    ThanhPho:<form:input path="thanhPho"/>
    QuocGia:<form:select path="quocGia">
    <form:option value="VietNam">VietNam</form:option>
    <form:option value="Lao">Lao</form:option>
</form:select>
    <form:button type="dubmit">Update</form:button>
</form:form>
</body>
</html>