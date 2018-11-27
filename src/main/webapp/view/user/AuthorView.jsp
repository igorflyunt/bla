<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../../layout/header.jsp"/>
<body>
<jsp:include page="../../layout/navbar.jsp"/>
<div class="container-fluid">
    <div class="row mx-auto">
        <div class="col-sm-6 mx-auto">
            <ul class="list-unstyled">
                <li class="media my-4 ">
                    <div class="media-object mr-3" style="width: auto">
                        <img src="https://via.placeholder.com/150" alt="...">
                    </div>
                    <div class="media-body text-left">
                        <h5 class="mt-0 mb-1 border-bottom">${author.firstName} ${author.lastName}</h5>
                        <p>${author.birthDate}</p>
                        <p>
                            <c:forEach items="${author.genres}" var="genre">
                                <span class="badge badge-light">${genre.genreName}</span>
                            </c:forEach>
                        </p>
                        <p class="book-description">
                            ${author.biography}
                        </p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="row mx-auto">
        <div class="col-lg-5 mx-auto">
            <h3 class="text-left"> ${indexPageName}</h3>
            <ul class="list-unstyled">
                <c:forEach items="${author.books}" var="book">
                    <li class="media py-2 my-4 mx-0 border-top">
                        <img class="book-cover-list media-object mr-3" src="https://images-na.ssl-images-amazon.com/images/I/51K84pomCRL._SX305_BO1,204,203,200_.jpg" alt="...">
                        <div class="media-body ">
                            <h5 class="mt-0 mb-1"><a class="custom-link" href="/book?bookid=${book.id}">${book.name}</a></h5>
                            <c:forEach items="${book.authors}" var="author" varStatus="loop">
                                <small>
                                    <a class="custom-link" href="/author?authorId=${author.id}">${author.firstName} ${author.lastName}
                                    </a>${loop.last ? "" : ",  "}
                                </small>
                            </c:forEach>
                        </div>
                        <div class="media-body col-lg-3">
                            <div class="btn-group float-right">
                                <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
<jsp:include page="../../layout/footer.jsp"/>
</body>
</html>
