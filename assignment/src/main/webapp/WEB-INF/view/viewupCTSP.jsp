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
<center><h1>Quản Lí Chi Tiết Sản Phẩm</h1></center>
<form:form action="/chi-tietSP/update/${chiTietSP.id}" method="post" modelAttribute="chiTietSP">
    IdSP11:
    <form:select class="form-control" path="sanPham">
        <c:forEach items="${listSP}" var="sp">
            <form:option value="${sp.id}" selected="${sp.id==chiTietSP.sanPham.id?'true':''}">${sp.ma}</form:option>
        </c:forEach>
    </form:select> <br>

    IdNSX:
    <form:select class="form-control" path="nsx">
        <c:forEach items="${listNSX}" var="nsx">
            <form:option value="${nsx.id}" selected="${nsx.id==chiTietSP.nsx.id?'true':''}">${nsx.ma}</form:option>
        </c:forEach>
    </form:select> <br>
    IdMS:
    <form:select class="form-control" path="mauSac">
        <c:forEach items="${listMS}" var="ms">
            <form:option value="${ms.id}" selected="${ms.id==chiTietSP.mauSac.id?'true':''}">${ms.ma}</form:option>
        </c:forEach>
    </form:select> <br>
    IdDSP:
    <form:select class="form-control" path="dongSP">
        <c:forEach items="${listDSP}" var="dsp">
            <form:option value="${dsp.id}" selected="${dsp.id==chiTietSP.dongSP.id?'true':''}">${dsp.ma}</form:option>
        </c:forEach>
    </form:select> <br>
    NamBH:<form:input class="form-control" path="namBH" type="number"/> <br>
    MoTa:<form:input class="form-control" path="moTa"/> <br>
    SoLuongTon:<form:input class="form-control" path="soLuongTon" type="number"/> <br>
    GiaNhap:<form:input class="form-control" path="giaNhap" type="text"/> <br>
    GiaBan:<form:input class="form-control" path="giaBan" type="text"/> <br>
    <form:button class="btn btn-primary" type="submit">Update</form:button>
</form:form>
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