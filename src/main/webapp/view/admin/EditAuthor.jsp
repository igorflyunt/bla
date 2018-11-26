<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="accordion"><c:forEach var="author" items="${authors}">
    <div class="row mx-auto accordion" id="authorItem${author.id}">
    <div class="col-lg-4 mx-auto my-2">
        <div class="row-fluid  mx-auto border-top media">
            <div class="media-object my-2">
                    ${author.firstName} ${author.lastName}
            </div>
            <div class="media-body my-2">
                <div class="float-right">
                    <div class="btn-group btn-group-sm">
                        <button class="btn btn-secondary btn-sm"
                                type="button" data-toggle="collapse" name="updateAuthorBtn" data-target="#author${author.id}"
                                aria-expanded="false" aria-controls="author${author.id}">
                            Edit
                        </button>
                        <button class="btn btn-secondary btn-sm float-right"
                                type="button" data-toggle="collapse" data-target="#newBook${author.id}"
                                aria-expanded="false" aria-controls="newBook${author.id}">Add book</button>
                        <a href="/admin/book?authorId=${author.id}">
                            <button class="btn btn-secondary btn-sm float-right" type="button">Books</button>
                        </a>
                        <button class="btn btn-danger btn-sm float-right" id="deleteAuthor${author.id}" name="authorId"
                                value="${author.id}"
                                type="button">
                            Delete
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid mx-auto">
                <div class="row-fluid my-2"><div class="collapse" data-parent="#accordion" id="newBook${author.id}"><form action="/admin/book" method="post">
                    <div class="form-group">
                        <label >Book name:</label>
                        <input type="text" class="form-control" name="bookName" placeholder="book name">
                    </div>
                    <div class="form-group">
                        <label>Book description:</label>
                        <textarea rows="7" class="form-control" name="bookDescription" placeholder="book description"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Year of publication:</label>
                        <input class="form-control" type="date" name="publicationYear" value="${author.birthDate}">
                    </div>
                    <input type="hidden" name="authorId" value="${author.id}">
                    <button type="submit" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
                </form></div></div>

        </div>
        <div class="row-fluid my-2"><div class="collapse" data-parent="#accordion" id="author${author.id}"><form action="/admin/author"
        method="post">
            <div class="form-group">
                <label>First name:</label>
                <input type="text" name="firstName" class="form-control" value="${author.firstName}" placeholder="author first name">
            </div>
            <div class="form-group">
                <label>Last name:</label>
                <input type="text" name="lastName" class="form-control" value="${author.lastName}" placeholder="author last name">
            </div>
            <div class="form-group">
                <label>Description:</label>
                <textarea class="form-control" name="biography" placeholder="author description" rows="7">${author.biography}</textarea>
            </div>
            <div class="form-group">
                <label>Birth date:</label>
                <input type="hidden" name="id" value="${author.id}">
                <input class="form-control" name="birthDate" type="date" value="${author.birthDate}">
            </div>
            <button  type="submit" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
        </form></div></div>
    </div>
</div></c:forEach></div>
