<%-- 
    Document   : ResultTest
    Created on : 22 трав. 2018, 14:39:53
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
        
        <title>Результати тестування</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    </head>
    <body>
               <div class="container">
 <form action="Account.jsp" method="post">
        
      <div class="form-group">
             <h2 class="text-center"> I так ваш результат:</h2>
           
             <p class="text-center">
           <label style="color: green">Кількість правильних відповідей:${k}</label> 
<!--         <input name="" type="text"  value="${k}"/>-->
            </p>
                <h2 class="text-center"> ${res_test}!</h2>
      </div>
 
     <p align="center">  <button  class="btn-lg btn-primary"  type="submit">Повторити тестування</button> </p>

 </div>
 
 </form>
              
    </body>
</html>
