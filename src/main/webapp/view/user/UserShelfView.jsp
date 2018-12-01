<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../../layout/header.jsp"/>
<body>
<jsp:include page="../../layout/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4 ">
            <div class="list-group text-center float-left">
                <a href="/user/bookshelf?shelf=all" class="list-group-item my-2">All</a>
                <a href="/user/bookshelf?shelf=currently-reading" class="list-group-item my-2">Currently reading</a>
                <a href="/user/bookshelf?shelf=read" class="list-group-item my-2">Read</a>
                <a href="/user/bookshelf?shelf=to-read" class="list-group-item my-2">To-Read</a>
            </div>
        </div>
        <div class="col-lg-4 ">
            <h3 class="text-justify"> ${shelfName}</h3>
            <ul class="list-unstyled">
                <c:forEach items="${shelfList}" var="shelf" varStatus="status">
                    <li class="media py-2 my-4 mx-0 border-top">
                        <img class="book-cover-list media-object mr-3" src="https://images-na.ssl-images-amazon.com/images/I/51K84pomCRL._SX305_BO1,204,203,200_.jpg" alt="...">
                        <div class="media-body">
                            <h6 class="mt-0 mb-1"><a class="custom-link" href="/book?bookid=${shelf.book.id}">${shelf.book.name}</a></h6>
                            <c:forEach items="${shelf.book.authors}" var="author" varStatus="loop">
                                <small>
                                    <a class="custom-link" href="/author?authorId=${author.id}">${author.firstName} ${author.lastName}
                                    </a>${loop.last ? "" : ",  "}
                                </small>
                            </c:forEach>
                        </div>
                        <div class="media-body col-lg-4" >
                            <div class="btn-group float-right">
                                <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            ${selectButtonShelfName[status.index]}
                                </button>
                                <div class="dropdown-menu">
                                    <form  method="post" action="/user/bookshelf" >
                                        <input type="hidden" name="bookId" value="${shelf.book.id}">
                                        <button type="submit" class="btn btn-secondary btn-sm dropdown-item" value="to-read"
                                                name="shelf">Want to read</button>
                                        <button type="submit" class="btn btn-secondary btn-sm dropdown-item" value="read"
                                                name="shelf">Read</button>
                                        <button type="submit" class="btn btn-secondary btn-sm dropdown-item" value="currently-reading"
                                                name="shelf">Currently reading</button>
                                    </form>
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
