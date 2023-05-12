<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<table class="table" style="font-size: 20px;">
    <thead>
    <tr>
        <th>Họ Tên</th>
        <th>SĐT</th>
        <th>Link FB</th>
        <th>Hình Ảnh Mô Tả</th>
    </tr>
    </thead>
    <tbody>
    <tr >
        <td scope="row" >${ten}</td>
        <td>${sdt}</td>
        <td><a href="${linkFB}">Sơn Đình Sơn</a></td>
        <td><img style="border-radius: 20px; width: 100px;height: 100px" src="https://scontent.fhan14-2.fna.fbcdn.net/v/t39.30808-6/337992340_205336342131104_546864219402506788_n.jpg?stp=cp6_dst-jpg&_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=g27kBP3J4CoAX9U4YjX&_nc_ht=scontent.fhan14-2.fna&oh=00_AfBI6mRanUSGbQJpizBVyqDi-XxBU_93QU5-KkALvnN7vQ&oe=64614EBD" alt="">
        </td>
    </tr>

    </tbody>
</table>
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