<%--
  Created by IntelliJ IDEA.
  User: iflyunt
  Date: 11/26/18
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row mx-auto">
    <div class="col-lg-4 mx-auto my-2">
        <div class="row-fluid my-2"><div class="collapse" id="newBook${author.id}"><form action="/admin/book" method="post">
            <div class="form-group">
                <label >Book name:</label>
                <input type="text" class="form-control" name="firstName" placeholder="book name">
            </div>
            <div class="form-group">
                <label>Book description:</label>
                <input type="text" class="form-control" name="lastName" placeholder="book description">
            </div>
            <div class="form-group">
                <label>Year of publication:</label>
                <input class="form-control" type="date" name="birthDate" value="${author.birthDate}">
            </div>
            <button type="submit" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
        </form></div></div>
    </div>
</div>
