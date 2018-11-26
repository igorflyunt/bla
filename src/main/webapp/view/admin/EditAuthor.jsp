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
                <button class="btn btn-secondary btn-sm float-right"
                        type="button" data-toggle="collapse" data-target="#author${author.id}"
                        aria-expanded="false" aria-controls="author${author.id}">
                    Edit
                </button>
            </div>
        </div>
        <div class="row-fluid my-2"><div class="collapse" id="author${author.id}"><form>
            <div class="form-group">
                <label for="formGroupExampleInput">First name:</label>
                <input type="text" class="form-control" value="${author.firstName}" id="formGroupExampleInput" placeholder="author first name">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Last name:</label>
                <input type="text" class="form-control" value="${author.lastName}" id="formGroupExampleInput2" placeholder="author last name">
            </div>
            <div class="form-group">
                <label for="descr">Description:</label>
                <textarea class="form-control" id="descr"  placeholder="author description" rows="7">
                        ${author.biography}
                </textarea>
            </div>
            <div class="form-group">
                <label for="birth-date">Birth date:</label>
                <input class="form-control" type="date" value="${author.birthDate}" id="birth-date">
            </div>
            <button type="button" class="btn btn-secondary btn-sm float-right mb-4">Save</button>
        </form></div></div>
    </div>
</div></c:forEach>
