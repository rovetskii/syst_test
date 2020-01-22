<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Реєстрація</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <form method="post" action="RegisterServlet" class="form-signin">
        <h2 class="form-heading">Реєстрація</h2>
        <div class="form-group">
            <p style="color: green">*Логін:</p>
            <input name="login" type="text"  required="required" id="name" class="form-control"/>
            <p style="color: green">*Пароль:</p>
            <input name="password" type="password"  required="required" class="form-control"/>
            <p style="color: green">*Прізвище:</p>
             <input name="family" type="text"  required="required" class="form-control"/>
            <p style="color: green">*Ім'я:</p>
            <input name="name" type="text"  required="required" class="form-control"/>
            <p style="color: green">*Група:</p>
            <input name="grup" type="text"  required="required" class="form-control"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="save" id="save">Зареєструватися!</button>
        </div>
    </form>
    
</div>
<!-- /container -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
