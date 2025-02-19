<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 2/19/25
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/SanPham/add" method="post">
    <label for="">Ten san pham</label>
    <input type="text" name="tenSanPham"> <br>

    <label for="">Ma san pham</label>
    <input type="text" name="maSanPham"> <br>

    <label for="">Trang thai</label>
        <input type="radio" name="trangThai" value="Hoat dong"> Hoat dong
        <input type="radio" name="trangThai" value="Khong hoat dong"> Khong hoat dong
        <br>
        <label for="">Mo ta</label>
        <input type="text" name="moTa"> <br>
        <select name="" id="">
            <c:forEach var="danhMuc" items="${listDanhMuc}">
                <option value="${danhMuc.id}"> ${danhMuc.tenDanhMuc}</option>
            </c:forEach>
        </select>

        <button type="submit">Add</button>
</form>
<table>
    <tr>
        <td>Ten san pham</td>
        <td>Ten danh muc</td>
        <td>Mo ta</td>
        <td>Ngay tao</td>
        <td>Trang thai</td>
    </tr>
    <tbody>
    <c:forEach var="sp" items="${list}">
        <tr>
            <td>${sp.ten}</td>
            <td>${sp.tenDanhMuc}</td>
            <td>${sp.moTa}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.trangThai}</td>
            <td>
                <a href="/SanPham/detail?id=${sp.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
