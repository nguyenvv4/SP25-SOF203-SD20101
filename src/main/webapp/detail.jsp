<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 20/1/25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/add" method="post">
    <label>id</label>
    <input type="text" name="id"> <br>
    <label>ho ten</label>
    <input type="text" name="hoTen"> <br>
    <label>tuoi</label>
    <input type="number" name="tuoi"> <br>
    <label>dia chi</label>
    <input type="text" name="diaChi"> <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
