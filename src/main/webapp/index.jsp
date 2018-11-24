<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="WEB-INF/layout/header.jsp"/>
<body>
<jsp:include page="WEB-INF/layout/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2 mx-0">
            <div class="list-group">
                <a href="#" class="list-group-item my-2">All</a>
                <a href="#" class="list-group-item my-2">Currently reading</a>
                <a href="#" class="list-group-item my-2">Read</a>
                <a href="#" class="list-group-item my-2">To-Read</a>
            </div>
        </div>

        <div class="col-lg-6 mx-auto">
            <ul class="list-unstyled">
                <c:forEach items="${books}" var="book">
                    <li class="media my-4 mx-auto">
                        <img class="book-cover-list media-object mr-3" src="https://images-na.ssl-images-amazon.com/images/I/51K84pomCRL._SX305_BO1,204,203,200_.jpg" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">${book.name}</h5>
                            <c:forEach items="${book.authors}" var="author">
                                <small>${author.firstName} ${author.lastName}  </small>
                            </c:forEach>
                        </div>
                        <div class="media-body">
                            <div class="btn-group ml-0">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Want to read
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Want to read</a>
                                    <a class="dropdown-item" href="#">Read</a>
                                    <a class="dropdown-item" href="#">Currently reading</a>
                                    <a class="dropdown-item" href="#">To read</a>
                                </div>
                            </div>
                        </div>

                    </li>
                </c:forEach>
            </ul>

            </div>
        </div>
    </div>
</div>
<jsp:include page="WEB-INF/layout/footer.jsp"/>
</body>
</html>
