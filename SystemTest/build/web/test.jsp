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
    <script src="jquery-3.2.1.min.js"> </script>
<!--    <style>
        textarea .t{text-indent: 0px;}
    </style>-->
<script>
    $(document).ready(function()
    {   
    
//       var size=<%=request.getSession().getAttribute("q")%>;
//     console.log("s="+size);
//   document.getElementById().rows=size; 
   });
    
    
    </script>
    </head>
    <body>
<!--        class="container"-->
        
       <div >
 <form action="TestServlet" method="post">
<!--        class="form-group"-->
      <div >
             <h2 class="text-center"> Вкажіть номер варіанту правильної відповіді</h2>
             <c:forEach items="${list}" var="t" >
                 <p>  <textarea  id="t1" style="color: green"   class="form-control"><c:out value="${t.quest}"/></textarea></p>
           <label style="color: green"> Варіанти відповідей: </label>
           <p><textarea  name="answer1" rows="4"   class="form-control"/><c:out value="${t.answer1}"/></textarea> </p>
              <label style="color: green"> Ваша відповідь: </label>
              <p> <input name="${t.id}" id="${t.id}" type="text"  required="required" class="form-control"/> </p>
      </c:forEach>      
      </div> 
     <p align="center">  <button  class="btn-lg btn-primary"  type="submit" name="answer_test">Перевірити тест</button> </p>
</form>
      
 </div>
        
        
        
        
    </body>
</html>
