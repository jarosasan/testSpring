<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/layouts/header.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-12 py-3 ">
            <h2 class="text-center">
                <c:if test="${empty plant.id}">
                    Add new person.
                </c:if>
                <c:if test="${!empty plant.id}">
                    Edit ${plant.name} Profile.
                </c:if>
            </h2>
        </div>
        <div class="col-12 pt-3 ">
            <c:url value="/add" var="urlAdd"/>
            <c:url value="/edit" var="urlEdit"/>
            <form:form method="post" modelAttribute="plant" cssClass="w-50 mx-auto"
                       action="${!empty plant.id?urlEdit:urlAdd}"
            >
            <c:if test="${!empty plant.id}">
                <form:hidden value="${plant.id}" path="id"/>
            </c:if>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


            <div class="form-group">
                <label for="name">Name</label>
                <form:label path="name" title="Name"/>
                <form:input path="name" cssClass="form-control" id="name"/>
                <form:errors cssClass="error" path="name"/>
            </div>
            <div class="form-group">
                <label for="name">Kiekis</label>
                <form:label path="amount" title="Name"/>
                <form:input path="amount" cssClass="form-control" id="amount"/>
                <form:errors cssClass="error" path="amount"/>
            </div>
            <div class="form-group">
                <form:label path="price" >Kaina</form:label>
                <form:input path="price" cssClass="form-control" id="price"/>
                <form:errors cssClass="error" path="price"/>
            </div>
            <div class="form-group">
                <form:label path="plantType">Tipas</form:label>
                <form:select path="plantType">
                    <option value="">--</option>
                    <option value=true >Daugametis</option>
                    <option value=false >Vienmetis</option>
                </form:select>
                <form:errors cssClass="error" path="plantType"/>
            </div>
            <div class="form-group">
                <label for="name">Aprasymas</label>
                <form:label path="descript" title="Name"/>
                <form:textarea path="descript" cssClass="form-control" id="descript"/>
                <form:errors cssClass="error" path="descript"/>
            </div>

            <button type="submit" class="btn btn-primary py-2 px-5">Save</button>
            <a class="btn btn-danger py-2 px-5" href="<c:url value="/"/> ">Cancel</a>
        </div>
        </form:form>
    </div>
</div>
</div>

<%@include file="/WEB-INF/view/layouts/footer.jsp" %>


</body>
</html>

