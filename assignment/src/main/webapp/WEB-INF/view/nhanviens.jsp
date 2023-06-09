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
<form:form action="/nhan-vien/add" method="post" modelAttribute="nhanVien">
    Ma:<form:input path="ma"/> <br>
    <form:errors path="ma" cssStyle="color: red"/> <br>

    Ten:<form:input path="ten"/><br>
    <form:errors path="ten" cssStyle="color: red"/> <br>

    TenDem:<form:input path="tenDem"/><br>
    <form:errors path="tenDem" cssStyle="color: red"/> <br>

    Ho:<form:input path="ho"/><br>
    <form:errors path="ho" cssStyle="color: red"/> <br>

    GioiTinh:<form:radiobutton path="gioiTinh" value="Nam"/>Nam
    <form:radiobutton path="gioiTinh" value="Nu"/>Nu <br>
    NgaySinh:<form:input type="date" path="ngaySinh"/><br>
    DiaChi:<form:input path="diaChi"/><br>
    <form:errors path="diaChi" cssStyle="color: red"/> <br>

    sdt:<form:input path="sdt"/><br>
    <form:errors path="sdt" cssStyle="color: red"/> <br>

    MatKhau:<form:input path="matKhau"/><br>
    <form:errors path="matKhau" cssStyle="color: red"/> <br>

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
    <form:radiobutton path="trangThai" value="0"/>NghiLam <br>
    <form:button type="dubmit">Add</form:button>
</form:form>
<table border="1px">
    <thead>
    <tr>
        <td>Ma</td>
        <td>HoVaTen</td>
        <td>GioiTinh</td>
        <td>NgaySinh</td>
        <td>DiaChi</td>
        <td>sdt</td>
        <td>MatKhau</td>
        <td>IdCH</td>
        <td>IdCV</td>
        <td>TrangThai</td>
        <td colspan="2">
            Avtion
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNV.content}" var="nv">
        <tr>
            <td>${nv.ma}</td>
            <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.cuaHang.ma}</td>
            <td>${nv.chucVu.ma}</td>
            <td>${nv.trangThai==1?"ConLam":"NghiLam"}</td>
            <td>
                <button><a href="/nhan-vien/remove/${nv.id}">Delete</a> </button>
                <button><a href="/nhan-vien/detail/${nv.id}">Update</a> </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="0" end="${listNV.totalPages -1}" varStatus="loop">
            <li>
                <a href="/nhan-vien/hien-thi?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>