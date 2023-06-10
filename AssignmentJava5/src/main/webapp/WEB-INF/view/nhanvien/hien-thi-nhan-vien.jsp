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
        <form:form action="/nhan-vien/add" method="post" modelAttribute="nhanVien">
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
            Giới Tính:<br>
            <form:radiobutton path="gioiTinh" value="Nam"/>Nam<br>
            <form:radiobutton path="gioiTinh" value="Nu"/>Nữ <br><br>
            Ngày Sinh:
            <form:input class="form-control" type="date" path="ngaySinh"/><br>
            Địa Chỉ:
            <form:input class="form-control" path="diaChi"/><br>
            <form:errors path="diaChi" cssStyle="color: red"/> <br>
            SĐT:
            <form:input class="form-control" path="sdt"/><br>
            <form:errors path="sdt" cssStyle="color: red"/> <br>
            Mật Khẩu:
            <form:input class="form-control" path="matKhau"/><br>
            <form:errors path="matKhau" cssStyle="color: red"/> <br>
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
                <td>Giới Tính</td>
                <td>Ngày Sinh</td>
                <td>Địa Chỉ</td>
                <td>SĐT</td>
                <td>Mật Khẩu</td>
                <td>ID Cửa Hàng</td>
                <td>ID Chức Vụ</td>
                <td>Trạng Thái</td>
                <td colspan="2">
                    Action
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
                    <td>${nv.trangThai==1?"Còn Làm":"Nghỉ Làm"}</td>
                    <td>
                        <a class="btn btn-warning" href="/nhan-vien/detail/${nv.id}">Update</a>
                        <a class="btn btn-danger" href="/nhan-vien/remove/${nv.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul>
                <c:forEach begin="0" end="${listNV.totalPages -1}" varStatus="loop">
                    <a href="/nhan-vien/hien-thi?page=${loop.begin + loop.count -1}">
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