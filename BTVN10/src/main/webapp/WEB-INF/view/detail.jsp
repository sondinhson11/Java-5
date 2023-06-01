<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <center><h2>Detail Lý Nhân Viên</h2></center>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <p><span>Mã:</span> <span>${nv.ma}</span></p>
        <p><span>Họ:</span> <span>${nv.ho}</span></p>
        <p><span>Tên Đệm:</span> <span>${nv.tenDem}</span></p>
        <p><span>Tên:</span> <span>${nv.ten}</span></p>
        <p><span>Giới Tính:</span> <span>${nv.gioiTinh}</span></p>
        <p><span>Chức Vụ:</span> <span>${nv.chucVu.ten}</span></p>
        <p><span>Cửa Hàng:</span> <span>${nv.cuaHang.ten}</span></p>
        <p><span>Năm Sinh:</span> <span>${nv.ngaySinh}</span></p>
    </div>
    <div class="col-1"></div>
</div>
<br>

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