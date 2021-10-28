<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Adlister: Search" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<form action="/search" method="POST">
    <div class="input-group mb-3 mt-5 px-3 input-group-large">
        <input type="text" class="form-control" placeholder="What would you like to find?" name="searchBar" aria-label="SearchBar" aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </div>
</form>

<br>

<div class="card-deck mx-3">
    <c:forEach var="ad" items="${ads}">
        <div class="col-4 d-flex flex-row card" style="width: 18rem;">
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
