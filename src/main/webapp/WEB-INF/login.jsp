<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<% String invalidLoginMessage = (String) session.getAttribute("invalidLoginMessage");
  if (null !=invalidLoginMessage) {%>
<h4> <%=invalidLoginMessage %></h4>
<%}
%>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
			<br>
			<div>
				<a href="/register">Don't have an account? Register here!</a>
			</div>
        </form>
        <c:choose>
            <c:when test = "${invalidLogin}" >
                <p>
                    Invalid Login!!!
                </p>
            </c:when>
        </c:choose>
    </div>

</body>
</html>
