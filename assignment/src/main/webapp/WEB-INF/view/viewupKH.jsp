<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Khach Hang</h1>
<form:form action="/khach-hang/update/${khachHang.id}" method="post" modelAttribute="khachHang">
    Ma:<form:input path="ma"/><br>
    Ten:<form:input path="ten"/><br>
    TenDem:<form:input path="tenDem"/><br>
    Ho:<form:input path="ho"/><br>
    NgaySinh:<form:input type="date" path="ngaySinh"/><br>
    sdt:<form:input path="sdt"/><br>
    DiaChi:<form:input path="diaChi"/><br>
    ThanhPho:<form:input path="thanhPho"/><br>
    QuocGia:<form:select path="quocGia"><br>
    <form:option value="HaNoi">HaNoi</form:option>
    <form:option value="Lao">Lao</form:option>
</form:select><br>
    MatKhau:<form:input path="matKhau"/><br>
    <form:button type="dubmit">Update</form:button>
</form:form>
</body>
</html>