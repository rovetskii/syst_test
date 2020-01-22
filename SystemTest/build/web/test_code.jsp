<%-- 
    Document   : testsyntax
    Created on : 20 трав. 2018, 17:34:42
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Тести</title>
         <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    </head>
    <body>
       <div class="container">
 <form action="TestServlet" method="post">
        
      <div class="form-group">
            <c:forEach items="${list}" var="t" >
           <label style="color: green"><c:out value="${t.quest}"/></label>
        <textarea  name="${t.id}" rows="20" required="required" class="form-control"/></textarea>
         </c:forEach>      
      </div> 
     <p align="center">  <button  class="btn-lg btn-primary"  type="submit" name="answer_test">Перевірити тест</button> </p>
</form>
      
 </div>
        
        
        
        
    </body>
</html>
