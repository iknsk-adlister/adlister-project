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
        <input type="text" class="form-control" placeholder="Search by Ad Title..." name="search-ads" aria-label="SearchBar" aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button name="ads-btn" type="submit" class="btn btn-primary">Search</button>
        </div>
    </div>
    <div class="input-group mb-3 mt-5 px-3 input-group-large">
        <input type="text" class="form-control" placeholder="Search by Username..." name="search-users" aria-label="SearchBar" aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button name="users-btn" type="submit" class="btn btn-primary">Search</button>
        </div>
    </div>
    <div class="input-group mb-3 mt-5 px-3 input-group-large">
        <input type="text" class="form-control" placeholder="Search by Category..." name="search-categories" aria-label="SearchBar" aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button name="categories-btn" type="submit" class="btn btn-primary">Search</button>
        </div>
    </div>
</form>

<br>

<div class="container">
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

</body>
</html>
