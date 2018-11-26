<%--
  Created by IntelliJ IDEA.
  User: iflyunt
  Date: 11/26/18
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="author" items="${authors}"><div class="row mx-auto">
    <div class="col-lg-4 mx-auto my-2">
        <div class="row-fluid  mx-auto border-top media">
            <div class="media-object my-2">
                    ${author.firstName} ${author.lastName}
            </div>
            <div class="media-body my-2">
                <div class="float-right">
                    <form action="/admin/author" method="post">
                        <button class="btn btn-secondary btn-sm mr-2"
                                type="button" data-toggle="collapse" data-target="#author${author.id}"
                                aria-expanded="false" aria-controls="author${author.id}">
                            Edit
                        </button>
                        <input type="hidden" value="${author.id}">
                        <button class="btn btn-danger btn-sm" name="delete" type="submit">Delete</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="row-fluid my-2"><div class="collapse" id="author${author.id}"><form action="/admin/author"
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
                <textarea class="form-control" name="biography" placeholder="author description" rows="7">
                        ${author.biography}
                </textarea>
            </div>
            <div class="form-group">
                <label>Birth date:</label>
                <input type="hidden" name="id" value="${author.id}">
                <input class="form-control" name="birthDate" type="date" value="${author.birthDate}">
            </div>
            <button  type="submit" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
        </form></div></div>
    </div>
</div></c:forEach>