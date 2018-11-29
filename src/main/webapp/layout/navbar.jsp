
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Bookworm</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/user/bookshelf?shelf=all">My Books</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/books">All Books</a>
                </li>
                <li class="nav-item ml-4">
                        <a href="/user/auth/signin" class="nav-link active btn btn-secondary btn-sm my-auto">Sign In</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
