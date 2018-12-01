<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../layout/header.jsp"/>

<body>
<jsp:include page="../../layout/adminnavbar.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" id="bookList">
    <div id="accordion"><c:forEach var="book" items="${books}">
        <div class="row mx-auto accordion" id="bookItem${book.id}">
            <div class="col-lg-4 mx-auto my-2">
                <div class="row-fluid  mx-auto border-top media">
                    <div class="media-object my-2">
                            ${book.name}
                    </div>
                    <div class="media-body my-2">
                        <div class="float-right">
                            <div class="btn-group btn-group-sm">
                                <button class="btn btn-secondary btn-sm"
                                        type="button" data-toggle="collapse" name="updateAuthorBtn" data-target="#book${book.id}"
                                        aria-expanded="false" aria-controls="book${book.id}">
                                    Edit
                                </button>
                                <button class="btn btn-danger btn-sm float-right" id="deleteBook${book.id}" name="deleteBookBtn"
                                        value="${book.id}"
                                        type="button">
                                    Delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid mx-auto">
                    <div class="row-fluid my-2"><div class="collapse" data-parent="#accordion" id="book${book.id}"><form action="/admin/book" method="post">
                        <div class="form-group">
                            <label >Book name:</label>
                            <input type="text" class="form-control" name="bookName" value="${book.name}" placeholder="book name">
                        </div>
                        <div class="form-group">
                            <label>Book description:</label>
                            <textarea rows="7" class="form-control"
                                      name="bookDescription" placeholder="book description">${book.description}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Year of publication:</label>
                            <input class="form-control" type="date" name="publicationYear" value="${book.firstPublished}">
                        </div>
                        <input type="hidden" name="bookId" value="${book.id}">
                        <button type="submit" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
                    </form></div></div>

                </div>
            </div>
        </div></c:forEach></div>
</div>

</body>
</html>
