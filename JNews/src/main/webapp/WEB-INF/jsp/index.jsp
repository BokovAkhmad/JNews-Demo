<%@ page import="jnews.controllers.JNewsController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Akhmat
  Date: 7.04.2016
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;">
    <title>Email</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#62cc73">
<center >
    <div class="hero-unit" style="width:400px;">

        <% if(!JNewsController.isEmailValid){%>
        <script type="text/javascript">
            alert("Please, enter valid E-mail!");
        </script>
        <% }%>

        <form class="form-horizontal" action="search" method="GET" name="search">
            <table class="table table-bordered" border="0" style="width:300px;" >
                <thead>
                <td><strong>Enter your e-mail for subscribing Java News:)</strong></td>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <div class="control-group">
                            <label class="control-label" >Your email:</label>
                            <div class="controls">
                                <input type="text" name="email" placeholder="Enter your e-mail">
                            </div>
                        </div>
                    </td>
                <tr>
                    <td>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-primary">Sign in</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>
</body>

</html>
