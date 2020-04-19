<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/view/layouts/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12 py-3 ">
            <h2 class="text-center">${plant.name}</h2>
        </div>
        <div class="col-12 my-2">
            <a class="btn btn-danger py-2 px-5" href="<c:url value="/"/> ">Back</a>
        </div>
        <div class="col-12 mt-5 ">
            <p>${plant.description.descripto}</p>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/view/layouts/footer.jsp" %>



