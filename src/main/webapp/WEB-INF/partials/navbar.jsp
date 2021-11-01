<%@ page import="com.codeup.adlister.models.User" %>
<nav class="navbar navbar-light bg-light navbar-expand-lg">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/welcome">Welcome!</a>
        </div>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/homeSearch">Search</a></li>
            <li class="nav-item"><a class="nav-link" href="/ads/create">Create Ads</a></li>
            <%
                if(session.getAttribute("user")== null) {
            %>
            <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
            <%
            }else{
            %>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>
            <%
                }
            %>
        </ul>
    </div><!-- /.navbar-collapse --><!-- /.container-fluid -->
</nav>