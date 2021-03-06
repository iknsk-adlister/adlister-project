<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create Your Own Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create Your Own Ad!</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Ad Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Describe it your Ad!</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
                <label for="categories">Select a category</label>
                <select id="categories">
                    <c:forEach var = "category" items="${categories}">
                        <option value="${category.name}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
			<div class="form-group">
				<label for="category">Category</label>
				<input id="category" name="category" class="form-control" type="text">
			</div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
