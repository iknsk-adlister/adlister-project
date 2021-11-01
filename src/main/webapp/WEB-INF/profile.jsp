<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1 class="">Welcome, ${sessionScope.username}!</h1>
        <a href="${pageContext.request.contextPath}/editProfile?" class="btn btn-primary" style="background-color: blueviolet">Update Profile</a>
    </div>

    <div class="container">
        <h2>Your ads:</h2>
        <div class="w3-row-padding">
            <div style="display: flex; flex-wrap: wrap; justify-content: center; align-items: center">
                <c:forEach var="ad" items="${ads}">
                    <div class="card" style="margin: auto">
                        <div class="card-body">
                            <h3 class="card-title">${ad.title}</h3>
                            <p>${ad.description}</p>
                                <%--                            <a href="#">${ads.categories}</a>--%>
                            <a href="${pageContext.request.contextPath}/ads/editads?id=${ad.id}" class="btn btn-primary" style="background-color: blueviolet">Edit</a>
                            <a href="${pageContext.request.contextPath}/ads/delete?id=${ad.id}"
                               onclick="return confirm('Are you sure you want to delete this ad?')"
                               class="btn btn-primary" style="background-color: blueviolet">Delete</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</body>
</html>
