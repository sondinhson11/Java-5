<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Nhan Vien</h1>
<form:form action="/nhan-vien/update/${nhanVien.id}" method="post" modelAttribute="nhanVien">
    Ma:<form:input path="ma"/> <br>
    Ten:<form:input path="ten"/><br>
    TenDem:<form:input path="tenDem"/><br>
    Ho:<form:input path="ho"/><br>
    GioiTinh:<form:radiobutton path="gioiTinh" value="Nam"/>Nam
    <form:radiobutton path="gioiTinh" value="Nu"/>Nu <br>
    NgaySinh:<form:input type="date" path="ngaySinh"/><br>
    DiaChi:<form:input path="diaChi"/><br>
    sdt:<form:input path="sdt"/><br>
    MatKhau:<form:input path="matKhau"/><br>
    IdCH:
    <form:select path="cuaHang">
        <c:forEach items="${listCH}" var="ch">
            <form:option value="${ch.id}" selected="${ch.id==nhanVien.cuaHang.id?'true':''}">${ch.ma}</form:option>
        </c:forEach>
    </form:select> <br>
    IdCV:
    <form:select path="chucVu">
        <c:forEach items="${listCV}" var="cv">
            <form:option value="${cv.id}" selected="${cv.id==nhanVien.chucVu.id?'true':''}">${cv.ma}</form:option>
        </c:forEach>
    </form:select> <br>
    TrangThai:<form:radiobutton path="trangThai" value="1"/>ConLam
    <form:radiobutton path="trangThai" value="0"/>NghiLam<br>
    <form:button type="dubmit">Update</form:button>
</form:form>
</body>
</html>