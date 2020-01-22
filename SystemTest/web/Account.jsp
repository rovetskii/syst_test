<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Система тестування</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>

<body>
 <div class="container">
 <form action="TestServlet" method="post" class="form-signin">
        <h1 class="text-center">Привіт ${student.name}!</h1>
       <div  class="text-center">
            <h2 style="color: green">Виберіть тест</h2>  
            <select class="btn-lg" name="test">   
            <option value="1"> Рівень 1. Синтаксис мови Java</option>
            <option value="2"> Рівень 2. Читання Java-коду</option>
            <option value="3"> Рівень 3. Написання Java-коду</option>
            </select>
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="test_student">Розпочати тестування</button>   
       </div>
      

</form>
 </div>
            

            
</body>

</html>
