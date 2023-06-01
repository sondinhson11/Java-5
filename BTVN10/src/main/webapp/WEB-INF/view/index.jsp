<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
        <center><h2>Quản Lý Nhân Viên</h2></center>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-1"><h5>Search:</h5></div>
    <div class="col-9">
        <form action="/nhan-vien/search-khoang-tuoi" method="post">
            <div class="form-group">
                <label>Tuổi Min</label>
                <input type="text" class="form-control" name="min">
            </div>
            <div class="form-group">
                <label>Tuổi Max</label>
                <input type="text" class="form-control" name="min">
            </div>
            <button type="submit" class="btn btn-primary">Tìm</button>
        </form>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <center><h3>ADD</h3></center>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <form action="/nhan-vien/add" method="post">
            <div class="form-group">
                <label>Mã</label>
                <input type="text" class="form-control" name="ma">
            </div>
            <div class="form-group">
                <label>Họ</label>
                <input type="text" class="form-control" name="ho">
            </div>
            <div class="form-group">
                <label>Tên Đệm</label>
                <input type="text" class="form-control" name="tenDem">
            </div>
            <div class="form-group">
                <label>Tên</label>
                <input type="text" class="form-control" name="ten">
            </div>
            <label>Giới Tính</label>
            <div class="form-check">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gioiTinh" value="Nam" checked>
                    Nam
                </label>
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gioiTinh" value="Nữ" checked>
                    Nữ
                </label>
            </div>
            <div class="form-group">
                <label>Ngày Sinh</label>
                <input type="date" class="form-control" value="2002-12-12" name="ngaySinh">
            </div>
            <div class="form-group">
                <label>Mã Chức Vụ</label>
                <select class="form-control" name="chucVu">
                    <c:forEach items="${dscv}" var="cv">
                        <option value="${cv.id}">${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Mã Cửa Hàng</label>
                <select class="form-control" name="cuaHang">
                    <c:forEach items="${dsch}" var="ch">
                        <option value="${ch.id}">${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">ADD</button>
        </form>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Mã</th>
                <th>Họ Và Tên</th>
                <th>Giới Tính</th>
                <th>Tuổi</th>
                <th>Chức Vụ</th>
                <th>Cửa Hàng</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${danhSach.content}" var="nv" varStatus="i">
                    <tr>
                        <td scope="row">${i.index+1}</td>
                        <td>${nv.ma}</td>
                        <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                        <td>${nv.gioiTinh}</td>
                        <td>${nv.ngaySinh}</td>
                        <td>${nv.chucVu.ten}</td>
                        <td>${nv.cuaHang.ten}</td>
                        <td><a class="btn btn-success" href="../nhan-vien/detail/${nv.id}">Detail</a></td>
                        <td><a class="btn btn-success" href="../nhan-vien/view-update/${nv.id}">Update</a></td>
                        <td><a class="btn btn-success" href="../nhan-vien/remove/${nv.id}">Remove</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <c:forEach begin="0" end="${danhSach.totalPages-1}" varStatus="i">
                        <a class="page-link" href="../nhan-vien/hien-thi?page=${i.begin + i.count-1}">
                                ${i.begin + i.count}
                        </a>
                    </c:forEach>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-1"></div>
</div>
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