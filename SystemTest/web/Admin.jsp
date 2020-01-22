<%-- 
    Document   : Admin
    Created on : 20 трав. 2018, 18:02:39
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Адміністрування</title>
          <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
 <form action="TestServlet" method="post" >
        <h1 class="text-center">Привіт ${student.name}!</h1>
      <div class="form-group">
                  <h2 style="color: green" class="text-center">Виберіть рівень складності тесту</h2>  
                  <p align="center"> <select class="btn btn-lg btn-primary" name="test" > </p>   
            <option value="1"> Рівень 1. Синтаксис мови Java</option>
            <option value="2"> Рівень 2. Читання Java-коду</option>
            <option value="3"> Рівень 3. Написання Java-коду</option>
            </select>
            
            <p style="color: green">Вкажіть запитання:</p>
            <textarea name="quest" rows="5" required="required" class="form-control"></textarea> 
            <p style="color: green">Вкажіть правильну відповідь:</p>
            <textarea name="answer" rows="5" required="required" class="form-control"></textarea> 
            <p style="color: green">Вкажіть варіанти відповідей або назву файлу для тестової програми:</p>
            <textarea name="answer1" rows="5" class="form-control"/> </textarea> 
           
       </div>
      
      <p align="center"> <button  type="submit" class="btn btn-lg btn-primary "  name="admin_test">Внести дані в Базу</button> </p>
</form>
      
 </div>
 
    </body>
</html>
