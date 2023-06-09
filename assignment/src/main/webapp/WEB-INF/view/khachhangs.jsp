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
<form:form action="/khach-hang/add" method="post" modelAttribute="khachHang">
    Ma:<form:input path="ma"/> <br>
    <form:errors path="ma" cssStyle="color: red"/> <br>
    Ten:<form:input path="ten"/><br>
    <form:errors path="ten" cssStyle="color: red"/> <br>
    TenDem:<form:input path="tenDem"/><br>
    <form:errors path="tenDem" cssStyle="color: red"/> <br>
    Ho:<form:input path="ho"/><br>
    <form:errors path="ho" cssStyle="color: red"/> <br>
    NgaySinh:<form:input type="date" path="ngaySinh"/><br>
    sdt:<form:input path="sdt"/><br>
    <form:errors path="sdt" cssStyle="color: red"/> <br>
    DiaChi:<form:input path="diaChi"/><br>
    <form:errors path="diaChi" cssStyle="color: red"/> <br>
    ThanhPho:<form:input path="thanhPho"/><br>
    <form:errors path="thanhPho" cssStyle="color: red"/> <br>
    QuocGia:<form:select path="quocGia">
    <form:option value="HaNoi">HaNoi</form:option>
    <form:option value="Lao">Lao</form:option>
</form:select><br>
    MatKhau:<form:input path="matKhau"/><br>
    <form:errors path="matKhau" cssStyle="color: red"/> <br>
    <form:button type="dubmit">Add</form:button>
</form:form>
<table border="1px">
    <thead>
    <tr>
        <td>Ma</td>
        <td>HoVaTen</td>
        <td>NgaySinh</td>
        <td>sdt</td>
        <td>DiaChi</td>
        <td>ThanhPho</td>
        <td>QuocGia</td>
        <td colspan="2">
            Avtion
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH.content}" var="kh">
        <tr>
            <td>${kh.ma}</td>
            <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>
                <button><a href="/khach-hang/remove/${kh.id}">Delete</a> </button>
                <button><a href="/khach-hang/detail/${kh.id}">Update</a> </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listKH.totalPages -1}" varStatus="loop">
            <li>
                <a href="/khach-hang/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>