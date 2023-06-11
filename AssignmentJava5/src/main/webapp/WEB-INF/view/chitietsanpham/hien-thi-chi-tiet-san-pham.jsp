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
<center><h1>Quản Lý Chi Tiết Sản Phẩm</h1></center>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <form:form action="/chi-tiet-san-pham/add" method="post" modelAttribute="chiTietSP">

            Id Sản Phẩm:
            <form:select class="form-control" path="sanPham">
                <c:forEach items="${listSP}" var="sp">
                    <form:option value="${sp.id}"
                                 selected="${sp.id==chiTietSP.sanPham.id?'true':''}">${sp.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            Id NSX:
            <form:select class="form-control" path="nsx">
                <c:forEach items="${listNSX}" var="nsx">
                    <form:option value="${nsx.id}"
                                 selected="${nsx.id==chiTietSP.nsx.id?'true':''}">${nsx.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            Id Màu Sắc:
            <form:select class="form-control" path="mauSac">
                <c:forEach items="${listMS}" var="ms">
                    <form:option value="${ms.id}"
                                 selected="${ms.id==chiTietSP.mauSac.id?'true':''}">${ms.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            Id DSP:
            <form:select class="form-control" path="dongSP">
                <c:forEach items="${listDSP}" var="dsp">
                    <form:option value="${dsp.id}"
                                 selected="${dsp.id==chiTietSP.dongSP.id?'true':''}">${dsp.ma}</form:option>
                </c:forEach>
            </form:select> <br>
            Năm BH:
            <form:input class="form-control" path="namBH" type="number"/> <br>
            <form:errors path="namBH" cssStyle="color: red"/><br>
            Mô Tả:
            <form:input class="form-control" path="moTa"/> <br>
            <form:errors path="moTa" cssStyle="color: red"/><br>
            Số Lượng Tồn:
            <form:input class="form-control" path="soLuongTon" type="number"/> <br>
            <form:errors path="soLuongTon" cssStyle="color: red"/><br>
            Giá Nhập:
            <form:input class="form-control" path="giaNhap" type="text"/> <br>
            <form:errors path="giaNhap" cssStyle="color: red"/><br>
            Giá Bán:
            <form:input class="form-control" path="giaBan" type="text"/> <br>
            <form:errors path="giaBan" cssStyle="color: red"/><br>
            <form:button class="btn btn-success" type="submit">Thêm</form:button>

        </form:form>
    </div>
    <div class="col-2"></div>
</div>
<br>

<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <table class="table" border="1px">
            <thead>
            <tr>
                <td>Id Sản Phẩm</td>
                <td>Id NSX</td>
                <td>Id Màu Sắc</td>
                <td>Id DongSP</td>
                <td>Năm BH</td>
                <td>Mô Tả</td>
                <td>Số Lượng Tồn</td>
                <td>Giá Nhập</td>
                <td>Giá Bán</td>
                <td colspan="2">
                    Hoạt Động
                </td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCTSP.content}" var="ctsp">
                <tr>
                    <td>${ctsp.sanPham.ma}</td>
                    <td>${ctsp.nsx.ma}</td>
                    <td>${ctsp.mauSac.ma}</td>
                    <td>${ctsp.dongSP.ma}</td>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.moTa}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>
                        <a href="/chi-tiet-san-pham/detail/${ctsp.id}" class="btn btn-warning">Update</a>
                        <a href="/chi-tiet-san-pham/remove/${ctsp.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul>
                <c:forEach begin="0" end="${listCTSP.totalPages -1}" varStatus="loop">
                    <a href="/chi-tiet-san-pham/hien-thi?page=${loop.begin + loop.count -1}">
                            ${loop.begin + loop.count}
                    </a>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-1"></div>
</div>
<br>

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