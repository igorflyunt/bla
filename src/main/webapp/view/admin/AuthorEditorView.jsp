<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../layout/header.jsp"/>

<body>
<jsp:include page="../../layout/adminnavbar.jsp"/>
<div class="container-fluid" id="author-list">
    <jsp:include page="AddAuthorView.jsp"/>
    <jsp:include page="EditAuthorView.jsp"/>
</div>
</body>
</html>
