<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../../../layout/header.jsp"/>
<body>
<jsp:include page="../../../layout/navbar.jsp"/>
<div class="container">
    <div class="row my-4">
        <div class="col-lg-4 mx-auto">
            <form>
                <div class="form-group"><input type="text" class="form-control" name="firstName" placeholder="First Name"></div>
                <div class="form-group"><input type="text" class="form-control" name="lastName" placeholder="Last Name"></div>
                <div class="form-group"><input type="text" class="form-control" name="username" placeholder="Username"></div>
                <div class="form-group"><input type="password" class="form-control" name="password" placeholder="Password"></div>
                <button type="submit" class="btn btn-secondary btn-sm">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../../../layout/footer.jsp"/>
</body>
</html>
