<%-- 
    Document   : register
    Created on : 20 трав. 2018, 13:01:35
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Вхід в систему тестування</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
        
    </head>
    <body>    
       <div class="container">
    <form method="POST" action="RegisterServlet" class="form-signin">
        <h2 class="form-heading">Вхід</h2>

        <div class="form-group">
            <p style="color: green">Введіть логін:</p>
            <input name="login" type="text" required="required" class="form-control"
                   autofocus="true"/>
            <p style="color: green">Введіть пароль:</p>
            <input name="password" type="password" required="required" class="form-control"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit" name="user">Ввійти!</button>
        </div>
    </form>
    <h4 class="text-center"><a href="RegisterAccount.jsp">Створити аккаунт!</a></h4>

</div>
<!-- /container -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        
          
        
        
        
    </body>
</html>
