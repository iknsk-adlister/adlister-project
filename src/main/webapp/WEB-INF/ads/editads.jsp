<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your Ad" />
    </jsp:include>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div>
        <a class="back-button" href="/profile">Back to Profile</a>
    </div>

    <div class="container">
        <h2>Edit your Ad</h2>

        <form action="/ads/editads" method="post">
            <div class="form-group">
                <label for="editTitle">Title</label>
                <input id="editTitle" name="editTitle" class="form-control" type="text" value="${title}">
                <input type="hidden" name="ad_id" value="${ad_id}">
            </div>
            <div class="form-group">
                <label for="editDescription">Description</label>
                <textarea id="editDescription" name="editDescription" class="form-control" type="text">${description}</textarea>
            </div>
            <input type="submit" class="btn btn-block">
        </form>


    </div>

</body>
</html>
