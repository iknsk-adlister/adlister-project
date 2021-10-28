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
        <h1>Welcome, ${sessionScope.user.username}!</h1>

    </div>

    <div class="container">

        <div class="col-6">
            <h2>Your ads:</h2>
            <c:forEach var="ad" items="${ads}">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title">${ad.title}</h3>
                        <p>${ad.description}</p>
                        <a href="#">${ad.categories}</a>
                        <button>Delete</button>
                    </div>
                </div>
            </c:forEach>
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
