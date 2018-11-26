<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layout/header.jsp"/>
<body>
<jsp:include page="../layout/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4 ">
            <div class="list-group text-center float-left">
                <a href="#" class="list-group-item my-2">All</a>
                <a href="#" class="list-group-item my-2">Currently reading</a>
                <a href="#" class="list-group-item my-2">Read</a>
                <a href="#" class="list-group-item my-2">To-Read</a>
            </div>
        </div>
        <div class="col-lg-5 ">
            <h3 class="text-justify"> ${indexPageName}</h3>
            <ul class="list-unstyled">
                <c:forEach items="${books}" var="book">
                    <li class="media py-2 my-4 mx-0 border-top">
                        <img class="book-cover-list media-object mr-3" src="https://images-na.ssl-images-amazon.com/images/I/51K84pomCRL._SX305_BO1,204,203,200_.jpg" alt="...">
                        <div class="media-body">
                            <h6 class="mt-0 mb-1"><a class="custom-link" href="/book?bookid=${book.id}">${book.name}</a></h6>
                            <c:forEach items="${book.authors}" var="author" varStatus="loop">
                                <small>
                                    <a class="custom-link" href="/author?authorId=${author.id}">${author.firstName} ${author.lastName}
                                    </a>${loop.last ? "" : ",  "}
                                </small>
                            </c:forEach>
                        </div>
                        <div class="media-body ">
                            <div class="btn-group float-right">
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
<jsp:include page="../layout/footer.jsp"/>
</body>
</html>
