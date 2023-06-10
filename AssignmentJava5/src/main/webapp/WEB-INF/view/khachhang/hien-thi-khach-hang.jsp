<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<center><h1>Quản Lý Khách Hàng</h1></center>

<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <form:form action="/khach-hang/add" method="post" modelAttribute="khachHang">
            Mã:
            <form:input class="form-control" path="ma"/> <br>
            <form:errors path="ma" cssStyle="color: red"/> <br>
            Tên:
            <form:input class="form-control" path="ten"/><br>
            <form:errors path="ten" cssStyle="color: red"/> <br>
            Tên Đệm:
            <form:input class="form-control" path="tenDem"/><br>
            <form:errors path="tenDem" cssStyle="color: red"/> <br>
            Họ:
            <form:input class="form-control" path="ho"/><br>
            <form:errors path="ho" cssStyle="color: red"/> <br>
            Ngày Sinh:
            <form:input class="form-control" type="date" path="ngaySinh"/><br>
            SĐT:
            <form:input class="form-control" path="sdt"/><br>
            <form:errors path="sdt" cssStyle="color: red"/> <br>
            Địa Chỉ:
            <form:input class="form-control" path="diaChi"/><br>
            <form:errors path="diaChi" cssStyle="color: red"/> <br>
            Thành Phố:
            <form:input class="form-control" path="thanhPho"/><br>
            <form:errors path="thanhPho" cssStyle="color: red"/> <br>
            Quốc Gia:
            <form:select class="form-control" path="quocGia">
                <form:option value="Việt Nam">Việt Nam</form:option>
                <form:option value="Lào">Lào</form:option>
            </form:select><br>
            Mật Khẩu:
            <form:input class="form-control" path="matKhau"/><br>
            <form:errors path="matKhau" cssStyle="color: red"/> <br>
            <form:button class="btn btn-success" type="submit">Thêm</form:button>
        </form:form>
        <br>
    </div>
    <div class="col-2"></div>
</div>

<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <table class="table" border="1px">
            <thead>
            <tr>
                <td>Mã</td>
                <td>Họ Và Tên</td>
                <td>Ngày Sinh</td>
                <td>SĐT</td>
                <td>Địa Chỉ</td>
                <td>Thành Phố</td>
                <td>Quốc Gia</td>
                <td colspan="2">
                    Action
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
                        <a class="btn btn-warning" href="/khach-hang/detail/${kh.id}">Update</a>
                        <a class="btn btn-danger" href="/khach-hang/remove/${kh.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul>
                <c:forEach begin="0" end="${listKH.totalPages -1}" varStatus="loop">
                    <a href="/khach-hang/hien-thi?page=${loop.begin + loop.count -1}">
                            ${loop.begin + loop.count}
                    </a>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-1"></div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>