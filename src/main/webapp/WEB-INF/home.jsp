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
	<select>
		<option value="all"></option>
   <c:forEach var = "category" items="${categories}">
	   <option value="${category.name}">${category.name}</option>
   </c:forEach>
	</select>
	<div class="container">
		<h1>Here Are all the ads!</h1>

			<div class="card-deck mx-3">
		<c:forEach var="ad" items="${ads}">
					<div class="col-4 d-flex flex-row card" style="width: 18rem;">
<%--						<img class="card-img-top" src="..." alt="Card image cap">--%>
						<div class="card-body">
							<h5 class="card-title">${ad.title}</h5>
							<p class="card-text">${ad.description}</p>
							<a href="#" class="btn btn-primary" style="background-color: blueviolet">Message Seller</a>
					</div>
				</div>
		</c:forEach>
			</div>
</body>
</html>
