<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>Giảng Viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10" style="border: solid;width: 300px">
        <form action="/giang-vien/search" method="post">
            <div class="form-group">
                <label>Tên:</label>
                <input type="text" class="form-control" name="ten">
            </div>
            <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
        </form>
    </div>
    <div class="col-1"></div>
</div>

<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <button type="button" class="btn btn-primary">Add Sinh Viên</button>
        <a href="/giang-vien/giang-vien-nu" class="btn btn-primary">Giảng Viên Nữ</a>
        <br>
        <br>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Tuổi</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsgv}" var="gv" varStatus="i">
                <tr>
                    <td>${gv.id}</td>
                    <td>${gv.ma}</td>
                    <td>${gv.ten}</td>
                    <td>${gv.tuoi}</td>
                    <td><c:if test="${gv.gioiTinh ==false}">Nữ</c:if>
                        <c:if test="${gv.gioiTinh ==true}">Nam</c:if>
                    </td>
                    <td>${gv.diaChi}</td>
                    <td><button><a href="">Detail</a></button></td>
                    <td><button><a href="">Delete</a></button></td>
                    <td><button><a href="">Update</a></button></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
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