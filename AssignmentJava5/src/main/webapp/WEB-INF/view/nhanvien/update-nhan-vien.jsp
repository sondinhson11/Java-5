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

<center><h1>Quản Lý Nhân Viên</h1></center>

<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <form:form action="/nhan-vien/update/${nhanVien.id}" method="post" modelAttribute="nhanVien">

            Mã:
            <form:input class="form-control" path="ma"/> <br>
            Tên:
            <form:input class="form-control" path="ten"/><br>
            Tên Đệm:
            <form:input class="form-control" path="tenDem"/><br>
            Họ:
            <form:input class="form-control" path="ho"/><br>
            Giới Tính: <br>
            <form:radiobutton path="gioiTinh" value="Nam"/>Nam<br>
            <form:radiobutton path="gioiTinh" value="Nu"/>Nữ <br><br>
            Ngày Sinh:
            <form:input class="form-control" type="date" path="ngaySinh"/><br>
            Địa Chỉ:
            <form:input class="form-control" path="diaChi"/><br>
            SĐT:
            <form:input class="form-control" path="sdt"/><br>
            Mật Khẩu:
            <form:input class="form-control" path="matKhau"/><br>
            ID Cửa Hàng:
            <form:select class="form-control" path="cuaHang">
                <c:forEach items="${listCH}" var="ch">
                    <form:option value="${ch.id}"
                                 selected="${ch.id==nhanVien.cuaHang.id?'true':''}">${ch.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            ID Chức Vụ:
            <form:select class="form-control" path="chucVu">
                <c:forEach items="${listCV}" var="cv">
                    <form:option value="${cv.id}"
                                 selected="${cv.id==nhanVien.chucVu.id?'true':''}">${cv.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            Trạng Thái:<br>
            <form:radiobutton path="trangThai" value="1"/>Còn Làm<br>
            <form:radiobutton path="trangThai" value="0"/>Nghỉ Làm <br><br>
            <form:button class="btn btn-success" type="submit">Sửa</form:button>
        </form:form>

        <br>
    </div>
    <div class="col-2"></div>
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