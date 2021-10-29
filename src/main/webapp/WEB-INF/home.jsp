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
	<form method="post" action="/home">
	<label for="category-search">Search for a category here:</label>
	<input id="category-search" type="text" name="category-search">
		<button name="category-btn" type="submit" class="btn btn-primary">Submit</button>
	</form>

	<div class="container">
		<h1>Here Are all the ads!</h1>
			<div class="row">
		<c:forEach var="ad" items="${ads}">
					<div class="col-4 d-flex flex-row card" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">${ad.title}</h5>
							<a  href="/details?adId=${ad.id}" class="btn btn-primary" style="background-color: blueviolet">Details</a>
							<a href="#" class="btn btn-primary" style="background-color: blueviolet">Edit</a>
						</div>
				</div>
		</c:forEach>
			</div>
	</div>
</div>
</body>
</html>
