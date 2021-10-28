<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Adlister: Welcome" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1 class="m-3 text-center">Adlister</h1>
<div class="card-deck mx-3">
    <div class="card" style="width: 20rem; height: 20rem;">
        <div class="card-body">
            <h5 class="card-title">Sign In/Sign Up</h5>
            <p class="card-text">Sign in to your account or create an account with us.</p>
            <a href="/login" class="btn btn-primary">Sign Up/Sign In</a>
        </div>
    </div>
    <div class="card" style="width: 20rem; height: 20rem;">
        <div class="card-body">
            <h5 class="card-title">Home</h5>
            <p class="card-text">Go to our home page. Here you can see all of our ads and/or categories:</p>
            <a href="/home" class="btn btn-primary">Home</a>
        </div>
    </div>
</div>
<div class="card-deck mt-3 mx-3">
    <div class="card" style="width: 20rem; height: 20rem;">
        <div class="card-body">
            <h5 class="card-title">Looking to Create a Listing?</h5>
            <p class="card-text">Go to our ad creation form here:</p>
            <a href="/ads/create" class="btn btn-primary">Create an Ad</a>
        </div>
    </div>
    <div class="card" style="width: 20rem; height: 20rem;">
        <div class="card-body">
            <h5 class="card-title">Search</h5>
            <div class="form-group">
                <form action="/welcome" method="POST">
                    <input type="text" class="form-control input-lg mt-4 mb-3" placeholder="Search for an Ad, User, or Category" name="homeInput">
                    <br>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>