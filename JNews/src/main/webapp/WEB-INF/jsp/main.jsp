<%--
  Created by IntelliJ IDEA.
  User: Akhmat
  Date: 7.04.2016
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Your News</title>
    <meta http-equiv="Content-Type" content="text/html;">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body style="background-color:rgba(255, 254, 242, 1)">

<table class="table table-striped">
    <thead>
    <tr>
        <th width="250" align="left">Title</th>
        <th width="250" align="center">Link</th>
    </tr>

    </thead>

    <tbody>
    <c:forEach items="${newsList}" var="news">
        <tr>
            <td width="250" align="center">${news.title}</td>
            <td width="250" align="center"><a href="${news.link}">${news.link}</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
