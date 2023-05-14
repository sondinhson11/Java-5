<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="../sinh-vien/hien-thi/tim-kiem" method="post">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${dssv}" var="sv" varStatus="i">
            <tr>
                <td scope="row">${i.index+1}</td>
                <td>${sv.mssv}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.gioiTinh}</td>
                <td><button><a href="">Detail</a></button></td>
                <td><button><a href="">Delete</a></button></td>
                <td><button><a href="">Update</a></button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
