<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly MS</h1>
<form:form action="/mau-sac/update/${mauSac.id}" method="post" modelAttribute="mauSac">
    Ma:<form:input path="ma"/>
    Ten:<form:input path="ten"/>
    <form:button type="dubmit">Update</form:button>
</form:form>
</body>
</html>