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

<div class="card">
    <div class="card-body">
        <h5 class="card-title">${ad.title}</h5>
        <p class="card-text">${ad.description}</p>
        <p class="card-text"><small class="text-muted">Posted by: ${user.username}</small></p>
    </div>
</div>
</body>
</html>
