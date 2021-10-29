<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = null;

    if (session != null){
        user = (User) session.getAttribute("user");
    }

    if(user != null) {
     request.setAttribute("navbar", "<a href=\"/welcome\">Home</a>"+
             "<li><a href=\"/profile\">Home</a></li>"+
             "<li><a href=\"/ads/search\">Search</a></li>"+
             "<li><a href=\"/ads/create\">Create Ads</a></li>"+
             "<li><a href=\"/logout\">Logout\"</a></li>");
    } else {
        request.setAttribute("navbar", "<li><a href=\"/welcome\">Adlister</a>" +
                "<li><a href=\"/login\">Log In</a></li>" +
                "<li><a href=\"/search\">Search</a></li>" +
                "<li><a href=\"/ads/create\">Create Ads</a></li>");
    }
  %>

<nav class="navbar navbar-light bg-light navbar-expand-lg">

    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/welcome">Welcome!</a>
        </div>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
            <li class="nav-item"><a class="nav-link" href="/search">Search</a></li>
            <li class="nav-item"><a class="nav-link" href="/ads/create">Create Ads</a></li>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
        </ul>
    </div><!-- /.navbar-collapse --><!-- /.container-fluid -->
</nav>