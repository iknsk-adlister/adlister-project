<%--
  Created by IntelliJ IDEA.
  User: shebbitywebbity
  Date: 10/26/21
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Home page" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h2>
        What are you looking for?
    </h2>
   <c:forEach var = "category" items="${categories}">
       <div class="col-md-4">
           <a href="/ads/categories">${category.name}</a>
       </div>
   </c:forEach>
</div>
</body>
</html>