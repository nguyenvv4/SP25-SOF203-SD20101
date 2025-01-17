<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 13/1/25
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach user la:</h1>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Ho Ten</td>
        <td>Tuoi</td>
        <td>Dia Chi</td>
        <td>Do tuoi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.hoTen}</td>
            <td>${user.tuoi}</td>
            <td>${user.diaChi}</td>
            <td> <c:if test="${user.tuoi > 18}">Thanh nien</c:if>
                <c:if test="${user.tuoi <= 18}">Tre con</c:if></td>
<%--            Toan tu 3 ngoi--%>
            <td>${user.tuoi > 18 ? "Thanh nien": "Tre con"} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
