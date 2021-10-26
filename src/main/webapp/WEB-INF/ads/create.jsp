<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create Your Own Ad" />
    </jsp:include>
</head>
<body>
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
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
