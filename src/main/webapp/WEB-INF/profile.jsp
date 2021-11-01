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
        <h1>Welcome, ${sessionScope.username}!</h1>
    </div>

    <div class="container">

        <div class="col-6">
            <h2>Your ads:</h2>
            <div class="display-flex flex-wrap-wrap justify-content-center align-items-center">
                <c:forEach var="ad" items="${ads}">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">${ad.title}</h3>
                            <p>${ad.description}</p>
<%--                            <a href="#">${ads.categories}</a>--%>
                            <a href="${pageContext.request.contextPath}/ads/edit?ad_id=${ad.id}" class="btn btn-primary" style="background-color: blueviolet">Edit</a>
                            <a href="${pageContext.request.contextPath}/ads/delete?ad_id=${ad.id}"
                               onclick="return confirm('Are you sure you want to delete this ad?')"
                               class="btn">Delete</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

<%--        bonus ? more complex feature--%>
<%--        <div class="col-6">--%>
<%--            <h2>Messages</h2>--%>
<%--            <c:forEach var="message" items="messages">--%>
<%--                <div class="card">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">${message.user}</h5>--%>
<%--                        <p>${message.description}</p>--%>
<%--                        <a href="#"></a>--%>
<%--                    </div>--%>

<%--                </div>--%>

<%--            </c:forEach>--%>

<%--        </div>--%>

    </div>

</body>
</html>
