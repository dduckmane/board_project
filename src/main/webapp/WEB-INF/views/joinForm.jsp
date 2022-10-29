<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-29
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<hr>
<form action="/join" method="post">
    <input type="text" name="username" placeholder="Username"><br>
    <input type="password" name="password" placeholder="Password"><br>
    <input type="email" name="email" placeholder="Email"><br>
    <button>회원가입</button>
</form>
<a href="/join">회원가입을 아직 하지 않으셨나요??</a>
</body>
</html>