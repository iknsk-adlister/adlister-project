<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your Profile" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div>
    <a class="back-button" href="/profile">Back to Profile</a>
</div>

<div class="container">
    <h2>Edit your Profile</h2>

    <form action="/user/update" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${user.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <textarea id="email" name="email" class="form-control" type="text">${user.email}</textarea>
        </div>
        <input type="submit" class="btn btn-block">
    </form>


</div>

</body>
</html>

