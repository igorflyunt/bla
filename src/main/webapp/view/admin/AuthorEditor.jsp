<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iflyunt
  Date: 11/25/18
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../layout/header.jsp"/>

<body>
<jsp:include page="../../layout/adminnavbar.jsp"/>
<div class="container-fluid" id="author-list">
    <jsp:include page="AddAuthor.jsp"/>
    <jsp:include page="EditAuthor.jsp"/>
</div>
</body>
</html>
